package org.dragonet.cloudland.server.util;

import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.UUID;

/**
 * Represents a String based key which consists of two components - a namespace
 * and a key.
 */
public final class NamespacedKey {

    /**
     * The namespace representing all inbuilt keys.
     */
    public static final String CLOUDLAND = "cloudland";

    //
    private final String namespace;
    private final String key;

    /**
     * Create a key in a specific namespace.
     *
     * @param namespace
     * @param key
     * @deprecated should never be used by plugins, for internal use only!!
     */
    @Deprecated
    public NamespacedKey(String namespace, String key) {
        Preconditions.checkArgument(namespace != null && !namespace.isEmpty(), "namespace");
        Preconditions.checkArgument(key != null, "key");

        this.namespace = namespace;
        this.key = key;

        String string = toString();
        Preconditions.checkArgument(string.indexOf(' ') == -1, "NamespacedKey cannot contain spaces (%s)", string);
        Preconditions.checkArgument(string.length() < 256, "NamespacedKey must be less than 256 characters", string);
    }

    public String getNamespace() {
        return namespace;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.namespace.hashCode();
        hash = 47 * hash + this.key.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NamespacedKey other = (NamespacedKey) obj;
        return this.namespace.equals(other.namespace) && this.key.equals(other.key);
    }

    @Override
    public String toString() {
        return this.namespace + ":" + this.key;
    }

    /**
     * Return a new random key in the {@link #CLOUDLAND} namespace.
     *
     * @return new key
     * @deprecated should never be used by plugins, for internal use only!!
     */
    @Deprecated
    public static NamespacedKey randomKey() {
        return new NamespacedKey(CLOUDLAND, UUID.randomUUID().toString());
    }

    /**
     * Get a key in the Minecraft namespace.
     *
     * @param key the key to use
     * @return new key in the Minecraft namespace
     */
    public static NamespacedKey cloudland(String key) {
        return new NamespacedKey(CLOUDLAND, key);
    }
}
