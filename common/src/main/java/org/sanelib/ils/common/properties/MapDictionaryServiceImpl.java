package org.sanelib.ils.common.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

@Service
@Scope("singleton")
public class MapDictionaryServiceImpl implements MapDictionaryService {

    private static final Logger LOG = LoggerFactory.getLogger(MapDictionaryServiceImpl.class);

	@Autowired
	private AppProperties appProperties;

    private final Map<String, Map<String, String>> mapDictionary = new ConcurrentHashMap<>();

	private Map<String, String> buildMapDictionary(String locale) {
		LOG.info("Generating MapDictionary");
		String messageBundle = appProperties.getMessageBundle();

		Map<String, String> keyValuePair = new HashMap<>();
		String directoryPath = "classpath:MessagesBundle/" + locale + "/*." + messageBundle;

		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

		try {
			Resource[] resources = resourceResolver.getResources(directoryPath);
			if (resources != null && resources.length != 0) {
				for (Resource resource : resources) {
					if (Objects.equals(messageBundle, "yml")) {
						buildResourceFromYaml(resource, keyValuePair);
					} else if (Objects.equals(messageBundle, "properties")) {
						buildResourceFromProperties(resource, keyValuePair);
					}
				}
			} else {
				LOG.error("Directory/Locale Not Found");
			}
		} catch (IOException e) {
			LOG.error("Directory/Locale Not Found.");
		}

		LOG.info("Finished Generating MapDictionary");

		return keyValuePair;
	}

	private void buildResourceFromProperties(Resource resource, Map<String, String> keyValuePair) throws IOException {
		Properties properties = new Properties();
		String prefix = resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
		properties.load(new FileInputStream(resource.getFile()));
		for (Object k : properties.keySet()) {
			String key = prefix + "." + k;
			keyValuePair.put(key, properties.getProperty(String.valueOf(k)));
		}
	}

	@SuppressWarnings("unchecked")
	private void buildResourceFromYaml(Resource resource, Map<String, String> keyValuePair) throws IOException {
		String prefix = resource.getFilename().substring(0, resource.getFilename().lastIndexOf("."));
		Yaml yaml = new Yaml();
		Map<String, Object> map = (Map<String, Object>) yaml.load(new FileInputStream(resource.getFile()));
		buildDictionary(prefix, keyValuePair, map);
	}

	@SuppressWarnings("unchecked")
	private void buildDictionary(String prefix, Map<String, String> keyValuePair, Map<String, Object> map) {
		for (String k : map.keySet()) {
			String key = prefix.length() > 0 ? prefix + "." + k : k;
            if (map.get(k) instanceof Map) {
				buildDictionary(key, keyValuePair, (Map<String, Object>) map.get(k));
			} else {
				keyValuePair.put(key, map.get(k).toString());
			}
		}
	}

	@Override
	public String generateMessage(String key, List<String> termNames, List<String> values) {

		final String locale = appProperties.getLocale();

        final String labelTokenMather = "^(~\\d)$";
        final String valueTokenMatcher = "^(\\^\\d)$";

        if (mapDictionary.get(locale) == null) {
			mapDictionary.put(locale, buildMapDictionary(locale));
		}

		final String template = mapDictionary.get(locale).get(key);

        StringBuilder response = new StringBuilder();

        StringTokenizer st = new StringTokenizer(template);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if(t.matches(labelTokenMather)){
                Integer pos = Integer.parseInt(t.substring(1));
                response.append(mapDictionary.get(locale).get(termNames.get(pos)));
            } else if(t.matches(valueTokenMatcher)){
                Integer pos = Integer.parseInt(t.substring(1));
                response.append(values.get(pos));
            } else {
                response.append(t);
            }
            response.append(" ");
         }

        return response.toString();
	}
}
