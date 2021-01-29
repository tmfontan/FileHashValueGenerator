/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehashgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 *  This Class is responsible for Computing the
 *  Unique Hash Value of the User Specified File
 *  using one of the Following Hash Algorithms:
 * 
 *      MD2         -   128-bit (32 Character) Message Digest 
 *                      Hash [For 8-bit Machines]
 * 
 *      MD5         -   128-bit (32 Character) Message Digest 
 *                      Hash [For 128-bit Machines]
 * 
 *      SHA-1       -   160-bit (40 Character) Secure Hashing
 *                      Algorithm Hash
 * 
 *      SHA-224     -   224-bit (56 Character) Secure Hashing
 *                      Algorithm Hash
 * 
 *      SHA-256     -   256-bit (64 Character) Secure Hashing
 *                      Algorithm Hash
 * 
 *      SHA-384     -   338-bit (96 Character) Secure Hashing
 *                      Algorithm Hash
 * 
 *      SHA-512     -   512-bit (128 Character) Secure Hashing
 *                      Algorithm Hash
 * 
 *  This Value is then Returned to the Calling GUI
 *  Class and Displayed for the User within the
 *  Hash Algorithm Value Text Area Component.
 * 
 *  @author     Tyler Fontana
 *  @date       January 21, 2020
 *  @version    1.0.0
 */
public class FileHashGenerator {

    /**
     * Global Char Array Used to Convert a Byte Array into
     * its String Equivalent Representation.
     */
    public static char[] HEX_ARRAY;

    /**
     *  This Basic Constructor is Used in order
     *  to Create a Reference to an Instance of
     *  this Class.
     */
    public FileHashGenerator() {
        /**
         * Create Reference, Nothing
         * Else to do.
         */
    }
    
    /**
     *  This Method is Responsible for Computing
     *  the Unique HEXIDECIMAL String Value that is
     *  Associated with the User's Specified File.
     *  Once this value has been calculated, it will
     *  be returned to the GUI Class where it is
     *  displayed for the User.
     * 
     *  @param obj      The Initial Custom HashObject
     *                  Variable which is defined with
     *                  the Hashing Algorithm Type and
     *                  Specified File within the GUI
     *                  Form.
     *
     *  @return         The HashObject Instance with the
     *                  updated Data detailing the overall
     *                  result of the operation.
     */
    public HashObject calculateHashValue(HashObject obj) {
        
        try {
            /**
             *  Create a New Message Digest Object and instantiate
             *  it with an instance of the Hashing Algorithm that
             *  the User has specified within the GUI Class.
             */
            MessageDigest digest = MessageDigest.getInstance(obj.getHashAlgorithm());
            /**
             *  Use the new Message Digest Object and User Specified
             *  File in order to calculate the Unique Hash Value.
             */
            String hashvalue = getFileChecksum(digest, obj.getFile());
            /**
             *  Set the Unique Hash Value within the custom object
             *  hash value field.
             */
            obj.setHashValue(hashvalue);
            
            /**
             *  Return the parameter custom object with
             *  the updated information to the GUI Form.
             */
            return obj;
        }
        /**
         *  If the Hash Value Calculation Process Fails, then
         *  return the custom HashObject Value with a result
         *  field value of false, and set the Exception Field
         *  String to the Type of Exception that has occurred.
         */
        catch (Exception e) {
            /**
             *  Set the Overall Result of 
             *  Hash Value Generation Operation
             *  as having Failed.
             */
            obj.setOperationResult(false);
            /**
             *  Save the Exception Message String
             *  within the custom HashObject Value.
             */
            obj.setExceptionType(e.toString());
            /**
             *  Return the HashObject Value.
             */
            return obj;
        }
    }
    
    
    /**
     *  This method is responsible for iterating through the
     *  contents of the user specified file in addition to
     *  building its HEXIDECIMAL Hash Value Representation
     *  depending on the Hash Algorithm Type also specified
     *  by the user.
     * 
     *  @param digest           The Message Digest Object Containing
     *                          the conditions and regulations of the
     *                          user's chosen Hash Algorithm Type.
     * 
     *  @param file             The File Object containing the Absolute
     *                          Path to the user's specified File.
     * 
     *  @return                 The File's Unique Hash Signature Associated
     *                          with the chosen Hash Value Type.
     * 
     *  @throws Exception       Should an Exception occur, throw it back
     *                          to the calling method for Error Handling
     *                          Purposes.
     */
    private static String getFileChecksum(MessageDigest digest, File file) throws Exception {
        
        /**
         *  Create new File Input Stream in order to read
         *  the user specified file. Should an Exception
         *  Occur, throw it back to the original calling
         *  method.
         */
        try ( 
            /**
             *  Open a new File Input Stream Object using
             *  the User Specified File as its Parameter.
             */
            FileInputStream fis = new FileInputStream(file)) {
            /**
             *  Create a new byte array object in order
             *  to read the contents of the file in
             *  separate chunks.
             */
            byte[] byteArray = new byte[1024];
            
            /**
             *  Create new Integer Value which is used
             *  to hold the number of remaining bytes
             *  left to read within the file.
             */
            int bytesCount = 0;
            /**
             *  Start Reading the User Specified File Until
             *  we have reached the end. Once the end of the
             *  file has been reached by the parser, the
             *  bytesCount Integer value will update to a
             *  Value of -1, which is used to symbolize that
             *  there are no bytes left to read in the file.
             */
            while ((bytesCount = fis.read(byteArray)) != -1) {
                /**
                 *  Let the Message Digest Object know how many
                 *  Bytes of the Total Amount are left to be
                 *  read.
                 */
                digest.update(byteArray, 0, bytesCount);
            };
            /**
             *  Once the File Contents have been read
             *  in their entirety, close the stream.
             */
        }
        /**
         *  Should an Exception have occurred, return
         *  to the calling method.
         */
        catch (Exception e) {
            /**
             *  Throw the Type of Exception
             *  Back to the Calling Method.
             */
            throw e;
        }

        /**
         *  Convert the File Hash into an
         *  Array of Bytes.
         */
        byte[] bytes = digest.digest();

        /**
         *  Seeing as the Hash Value Byte Array 
         *  is currently represented in Decimal
         *  Bytes, we need to convert them into
         *  HEXIDECIMAL Characters. These Characters
         *  will then be saved into the StringBuilder
         *  Object before being returned to the 
         *  calling method.
         */
        StringBuilder sb = new StringBuilder();
        /**
         *  Continuously Loop through the Hash Value
         *  Byte Array and convert each Decimal Byte
         *  into its HEXIDECIMAL String representation.
         */
        for(int i=0; i< bytes.length ;i++) {
            /**
             *  Convert the Current Byte to its
             *  HEXIDECIMAL String Representation and
             *  Append it to the end of the String.
             */
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

       /**
        *   Return the Newly Generated
        *   HEXIDECIMAL Hash Value of the File.
        */
       return sb.toString();
    }
}
