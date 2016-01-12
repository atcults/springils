package org.sanelib.ils.common.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReflectionHelperTest {

    public class BaseClass {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class DerivedClass extends BaseClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void testSameTypeObjectShouldCopyByReflection() throws Exception {
        BaseClass src = new BaseClass();
        src.setId(1);

        DerivedClass dest = new DerivedClass();

        ReflectionHelper.copy(src, dest);

        assertEquals(src.getId(), dest.getId());
    }
}
