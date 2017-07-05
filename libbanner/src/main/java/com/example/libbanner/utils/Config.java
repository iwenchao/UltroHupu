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
        public  static class Style {
            public static final int   NO_INDICATOR = 0;
            public static final int  CIRCLE_INDICATOR= 1;
            public static final int  NUM_INDICATOR= 2;
            public static final int  NUM_WITH_TITLE_INDICATOR= 3;
            public static final int  CIRCLE_WITH_TITLE_INDICATOR= 4;
            public static final int  CIRCLE_WITH_INSIDE_TITLE_INDICATOR= 5;


        }


        /**
         *
         */
        public  static class Gravity {
            public static final int LEFT = 0;
            public static final int  CENTER = 1;
            public static final int RIGHT = 2;
        }
    }


    public static class Banner {
        public static final int PADDING = 5;
        public static final int MARGIN = 5;
        public static final int DELAY_TIME = 2000;
        public static final int DURATION = 800;
        public static final boolean AUTO_PLAY = true;
        public static final boolean CAN_SCROLL = true;


        /**
         * title style
         */
        public static final int TITLE_BACKGROUND = -1;
        public static final int TITLE_HEIGHT = -1;
        public static final int TITLE_TEXT_COLOR = -1;
        public static final int TITLE_TEXT_SIZE = -1;
    }


}
