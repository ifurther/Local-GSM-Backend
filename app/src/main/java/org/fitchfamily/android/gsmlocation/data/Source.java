package org.fitchfamily.android.gsmlocation.data;

import android.text.TextUtils;

import java.io.IOException;

public final class Source {
    private final String url;

    private final Compression compression;

    public Source(String url, Compression compression) {
        if (TextUtils.isEmpty(url) || compression == null) {
            throw new NullPointerException();
        }

        this.url = url;
        this.compression = compression;
    }

    public Compression compression() {
        return compression;
    }

    public String url() {
        return url;
    }

    public SourceConnection connect() throws IOException {
        return new SourceConnection(this);
    }

    @Override
    public String toString() {
        return url() + " (" + compression().name() + ")";
    }

    public enum Compression {
        gzip
    }
}
