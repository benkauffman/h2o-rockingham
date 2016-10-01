package com.krashidbuilt;

import com.krashidbuilt.info.General;
import com.krashidbuilt.magic.Pdf2TiffConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Ben Kauffman on 09/30/16.
 */
public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws IOException {

        String[] arg = new String[]{"/Users/benkauffman/development/java/h2o-rockingham/images/pdf"};
        args = arg;

        General general = null;
        try {
            general = new General();
        } catch (URISyntaxException e) {
            logger.error("UNABLE TO GET SOURCE DIRECTORY", e);
        }

        File source = general.getSourceDir(args);
        logger.debug("Source directory is set to {}", source);

        File[] pdfs = general.getFilesInSource("pdf");
        logger.debug("{} PDFs found in source matching the filter criteria", pdfs.length);

        for(File pdf : pdfs){
            logger.debug("converting pdf {}", pdf.getName());
            Pdf2TiffConverter.savePdfAsTiff(pdf);
        }




    }
}