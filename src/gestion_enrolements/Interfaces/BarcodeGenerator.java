/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.Interfaces;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author tepitech
 */
public class BarcodeGenerator {
    
    private static final int BARCODE_LENGTH = 13;

    public BarcodeGenerator() {
        // Constructeur de la classe
    }

    public String generateBarcode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < BARCODE_LENGTH; i++) {
            sb.append((char) (random.nextInt(10) + '0')); // Génère un chiffre aléatoire
        }

        return sb.toString();
    }

    public BufferedImage generateBarcodeImage(String barcodeText) throws IOException {
        Code128Bean bean = new Code128Bean();
        final int dpi = 150;

        bean.setModuleWidth(0.3);
        bean.doQuietZone(false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BitmapCanvasProvider provider = new BitmapCanvasProvider(out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        bean.generateBarcode(provider, barcodeText);
        provider.finish();

        return provider.getBufferedImage();
    }
}
