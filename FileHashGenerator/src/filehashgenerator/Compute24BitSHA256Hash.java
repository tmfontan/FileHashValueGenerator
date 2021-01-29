/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehashgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tylerfontana
 */
public class Compute24BitSHA256Hash {
    
    // Global Char Array Used to Convert a Byte Array into
    // its String Equivalent Representation.
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    
    private static final String MD2 = "MD2";
    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA-1";
    private static final String SHA224 = "SHA-224";
    private static final String SHA256 = "SHA-256";
    private static final String SHA384 = "SHA-384";
    private static final String SHA512 = "SHA-512";
    
    public static void main(String[] args) {
        
        File file = new File("/Users/tylerfontana/NetBeansProjects/FileVerification/src/main/java/com/mycompany/fileverification/Question_Two_Files/q3_letter_Oscar.txt");
        
        try {
                //Use SHA-1 algorithm
                MessageDigest DIGEST_SHA256 = MessageDigest.getInstance("SHA-256");
                //SHA-1 checksum 
                String HASH_STRING_SHA256 = getFileChecksum(DIGEST_SHA256, file);
                
                System.out.println("File: q3_letter.txt Hash Value: " + HASH_STRING_SHA256);
        }
        catch (IOException | NoSuchAlgorithmException ie) {
            ie.printStackTrace();
        }
    }
    
    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0; 

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
            System.out.println("\n" + bytesToHex(byteArray));
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
       return sb.toString();
    }
    
    /**
     *  This Method is Used to Convert the Parameter
     *  Byte Array into its String Equivalent Form.
     *  (Note: This Method is Only Used for Programmer
     *  Process Checking.)
     * 
     *  @param bytes        The Byte Array to be Converted
     *                      into a String Variable.
     * 
     *  @return             The String Equivalent of the
     *                      Byte Array.
     */
    public static String bytesToHex(byte[] bytes) {
        // Create New Char Array From the Bytes Array
        // Length. 
        char[] hexChars = new char[bytes.length * 2];
        // Loop Until We have Created our New Char
        // Array.
        for (int j = 0; j < bytes.length; j++) {
            // Convert Current Byte Array Entry
            // into Hexidecimal Format.
            int v = bytes[j] & 0xFF;
            // Shift Bits to Right By 4
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            // Convert the Hexidecimal Formated
            // Byte into its Char Equivalent and Store
            // it in the Array.
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        // Create New String From Char Array.
        return new String(hexChars);
    }
}
