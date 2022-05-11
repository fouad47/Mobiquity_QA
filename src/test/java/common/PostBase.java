package common;

import constants.Endpoint;

public enum PostBase implements Base {
        POST(Endpoint.GET_POSTS);

        private final String basePath;

        PostBase(String basePath){
            this.basePath = basePath;
        }

        @Override
        public String path() {
            return basePath;
        }
}
