package org.eclipse.edc.connector.dataplane.aws.s3.arguments;

import java.util.ArrayList;
import java.util.List;

public class S3DataPlaneIntegrationTestArgument {
    public List<String> getKeys() {
        return keys;
    }

    public String getBody() {
        return body;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public String getKeyPrefixDelimiter() {
        return keyPrefixDelimiter;
    }

    private List<String> keys;
    private String body;
    private String keyPrefix;
    private String keyPrefixDelimiter;

    private S3DataPlaneIntegrationTestArgument() {

    }

    public String getExpectedKey() {
        if (keys.size() == 1) {
            return keys.get(0);
        }
        return keyPrefix;
    }

    public List<String> getExpectedKeys() {
        if (keys.size() == 1) {
            return keys;
        }
        return this.keys.stream().map(key -> keyPrefix + keyPrefixDelimiter + key).toList();
    }

    public static class Builder {
        private final S3DataPlaneIntegrationTestArgument argument;

        private Builder() {
            this.argument = new S3DataPlaneIntegrationTestArgument();
        }

        public static S3DataPlaneIntegrationTestArgument.Builder newInstance() {
            return new S3DataPlaneIntegrationTestArgument.Builder();
        }

        public S3DataPlaneIntegrationTestArgument.Builder keys(List<String> keys) {
            argument.keys = keys;
            return this;
        }

        public S3DataPlaneIntegrationTestArgument.Builder addKey(String key) {
            if (argument.keys == null) {
                argument.keys = new ArrayList<>();
            }
            argument.keys.add(key);
            return this;
        }

        public S3DataPlaneIntegrationTestArgument.Builder body(String body) {
            argument.body = body;
            return this;
        }

        public S3DataPlaneIntegrationTestArgument.Builder keyPrefix(String keyPrefix) {
            argument.keyPrefix = keyPrefix;
            return this;
        }

        public S3DataPlaneIntegrationTestArgument.Builder keyPrefixDelimiter(String keyPrefixDelimiter) {
            argument.keyPrefixDelimiter = keyPrefixDelimiter;
            return this;
        }

        public S3DataPlaneIntegrationTestArgument build() {
            return argument;
        }
    }
}
