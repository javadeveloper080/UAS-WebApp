package org.edu.uams.server.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.aspose.words.Document;

public final class DocBuilder {

    public static Document getAsposeDocument(org.edu.uams.server.api.Document appDocument) throws Exception {
        if (appDocument == null) {
            throw new IllegalArgumentException("appDocument cannot be null");
        }
        Document doc = null;
        if (DocumentConverter.isWordDoc(appDocument)) {
            try (InputStream inStream = new ByteArrayInputStream(appDocument.getFileBytes())) {
                doc = new Document(inStream);
            }
        }
        return doc;
    }
}