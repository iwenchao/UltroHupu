package com.example.libbanner.utils;

/**
 * Created by chaos
 * On 17-7-4.
 * Email:iwenchaos@gmail.com
 * Description:
 */

public class Config {

    public static class Indicator {

        /**
         *
         */
        public static enum Style {
            NO_INDICATOR(0),
            CIRCLE_INDICATOR(1),
            NUM_INDICATOR(2),
            NUM_WITH_TITLE_INDICATOR(3),
            CIRCLE_WITH_TITLE_INDICATOR(4),
            CIRCLE_WITH_INSIDE_TITLE_INDICATOR(5);


            private int value;

            private Style(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }


        }


        /**
         *
         */
        public static enum Gravity {
            LEFT(0),
            CENTER(1),
            RIGHT(2);

            private int value;

            private Gravity(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }
        }
    }


    public static class Banner {
        public static final int PADDING = 5;
        public static final int MARGIN = 5;
        public static final int DELAY_TIME = 2000;
        public static final int DURATION = 800;
        public static final boolean AUTO_PLAY = true;
        public static final boolean CAN_SCROLL = true;
    }


}
