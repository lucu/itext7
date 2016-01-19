package com.itextpdf.core.pdf.navigation;

import com.itextpdf.core.pdf.PdfArray;
import com.itextpdf.core.pdf.PdfName;
import com.itextpdf.core.pdf.PdfObject;

import java.util.Map;

public class PdfNamedDestination extends PdfDestination<PdfName> {

    public PdfNamedDestination(String name) {
        this(new PdfName(name));
    }

    public PdfNamedDestination(PdfName pdfObject) {
        super(pdfObject);
    }

    @Override
    public PdfObject getDestinationPage(final Map<Object, PdfObject> names) {
        PdfArray array = (PdfArray) names.get(getPdfObject());

        return array != null ? array.get(0, false) : null;
    }

    @Override
     public PdfDestination replaceNamedDestination(final Map<Object, PdfObject> names){

        PdfArray array = (PdfArray) names.get(getPdfObject());
        if (array != null){
            return PdfDestination.makeDestination(array);
        }
        return null;
    }
}
