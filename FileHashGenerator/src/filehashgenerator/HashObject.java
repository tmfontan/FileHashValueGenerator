/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehashgenerator;

import java.io.File;

/**
 *  This Class is used in order to create
 *  a custom Object responsible for holding
 *  the overall result, details, value of the
 *  File Hashing Operation, or possible exception
 *  type that are found during the Hash Value
 *  Generation Process.
 * 
 *  @author     Tyler Fontana
 *  @date       January 28, 2021
 *  @version    1.0.0
 */
public class HashObject {
    
    // The Overall Result
    public boolean result;
    // The Type of Hashing Algorithm
    public String algorithm;
    // The Selected File
    public File file;
    // The Final Hash String
    public String hashvalue;
    // The Type of Exception
    public String exception;
    
    /**
     *  This method is responsible for creating a new
     *  instance of the HashObject Custom Object. This
     *  Object will be used to retrieve the overall results
     *  of the File Hashing Process for the GUI Form.
     * 
     *  @param res          The Overall Result of the File Hashing 
     *                      Operation. 
     * 
     *                      True    -   File Hashing Successful
     *                      False   -   File Hashing Failure
     * 
     *  @param type         The Hashing Algorithm Type that the
     *                      User has specified. 
     * 
     *                      Possibilities Include:
     * 
     *                      MD2         -       128-bit (32 Character) Message Digest 
     *                                          Hash [For 8-bit Machines]
     * 
     *                      MD5         -       128-bit (32 Character) Message Digest 
     *                                          Hash [For 128-bit Machines]
     * 
     *                      SHA-1       -       160-bit (40 Character) Secure Hashing
     *                                          Algorithm Hash
     * 
     *                      SHA-224       -     224-bit (56 Character) Secure Hashing
     *                                          Algorithm Hash
     * 
     *                      SHA-256       -     256-bit (64 Character) Secure Hashing
     *                                          Algorithm Hash
     * 
     *                      SHA-348       -     338-bit (96 Character) Secure Hashing
     *                                          Algorithm Hash
     * 
     *                      SHA-512       -     512-bit (128 Character) Secure Hashing
     *                                          Algorithm Hash
     * 
     *  @param userfile     The User specified File which we will be
     *                      generating a unique hash value for.
     * 
     *  @param value        The Unique Hash String which identifies
     *                      the user specified file in its current
     *                      state.
     * 
     *  @param ex           The Exception Type that may possibly occur
     *                      while generating the unique hash value.
     */
    public HashObject(boolean res, String type, File userfile, String value, String ex) {
        // Set the Overall Result
        this.result = res;
        // Set the Hashing Algorithm Type
        this.algorithm = type;
        // Set the User Specified File
        this.file = userfile;
        // Set the Unique Hash String
        this.hashvalue = value;
        // Set Exception Type
        this.exception = ex;
    }
    
    /**
     *  This method is used to retrieve the
     *  Overall result boolean value of the 
     *  Hashing Operation from within the
     *  Custom Hash Object.
     * 
     *  @return     The Result of the Hashing
     *              Operation.
     */
    public boolean getOperationResult() {
        // Return Boolean Result Value.
        return this.result;
    }
    
    /**
     *  This method is used to retrieve the
     *  Hashing Algorithm type that is associated
     *  with the Operation.
     * 
     *  @return     The Type of Hashing Algorithm
     *              that the user has specified.
     */
    public String getHashAlgorithm() {
        // Return Hash Type String
        return this.algorithm;
    }
    
    /**
     *  This method is used in order to retrieve
     *  the user specified File associated with
     *  the custom Hash Value String.
     * 
     *  @return     The user chosen file which
     *              we using to create the unique
     *              hash string.
     */
    public File getFile() {
        // Return User Specified File.
        return this.file;
    }
    
    /**
     *  This method is used in order to retrieve
     *  the unique Hash String Value created during
     *  the Hashing Algorithm. This Value is used
     *  in order to identify the user specified value
     *  in its current state. If the file changes in
     *  any way, then this unique hash value will
     *  completely change.
     * 
     *  @return     The hash value of the user's
     *              chosen file in its current state.
     */
    public String getHashValue() {
        // Return Unique Hash Value of File.
        return this.hashvalue;
    }
    
    /**
     *  This method is used to return the type
     *  of exception should one occur during the
     *  Hash Value Generation Process.
     * 
     *  @return     The Exception Type
     */
    public String getExceptionType() {
        // Return Exception Type
        return this.exception;
    }
    
    /**
     *  This setter method is used in order to set
     *  the Overall Result of the Hashing Operation
     *  for the user specified file. This variable will
     *  evaluate to one of the following two values:
     * 
     *  True    -   The Hashing Process was a Success.
     *  False   -   The Hashing Process has Failed.
     * 
     *  @param value    The boolean value which lets
     *                  the calling GUI Form know whether
     *                  the Hashing Process has Succeeded
     *                  or Failed for the chosen file.
     */
    public void setOperationResult(boolean value) {
        // Set Overall Result
        this.result = value;
    }
    
    /**
     *  This setter method is used in order to set
     *  the Type of Hashing Algorithm that the
     *  Application will use to create a custom
     *  Hash String for the User Specified File.
     *  This Value will be one of the following
     *  Strings Provided below:
     *  
     *  MD2         -       128-bit (32 Character) Message Digest 
     *                      Hash [For 8-bit Machines]
     * 
     *  MD5         -       128-bit (32 Character) Message Digest 
     *                      Hash [For 128-bit Machines]
     * 
     *  SHA-1       -       160-bit (40 Character) Secure Hashing
     *                      Algorithm Hash
     * 
     *  SHA-224       -     224-bit (56 Character) Secure Hashing
     *                      Algorithm Hash
     * 
     *  SHA-256       -     256-bit (64 Character) Secure Hashing
     *                      Algorithm Hash
     * 
     *  SHA-348       -     338-bit (96 Character) Secure Hashing
     *                      Algorithm Hash
     * 
     *  SHA-512       -     512-bit (128 Character) Secure Hashing
     *                      Algorithm Hash
     * 
     *  @param value    The Hashing Algorithm String Type
     */
    public void setHashAlgorithm(String value) {
        //  Set Hash Algorithm Type
        this.algorithm = value;
    }
    
    /**
     *  This Setter Method is used in Order to
     *  Set the User Specified File which we will
     *  generate the Hash Checksum of.
     * 
     *  @param value    A File Object Containing
     *                  the Absolute Path to the
     *                  File that the User wishes
     *                  to create a Checksum for.
     */
    public void setFile(File value) {
        // Set File Object.
        this.file = value;
    }
    
    /**
     *  This Setter Method is used in order to
     *  set the String Value of the newly Generated
     *  Hash Checksum.
     * 
     *  @param value        A String containing the
     *                      unique identifying Checksum
     *                      of the User Specified File.
     */
    public void setHashValue(String value) {
        // Set the Hash String Value.
        this.hashvalue = value;
    }
    
    /**
     *  This Setter Method is used in order to
     *  set the String Exception Type that may
     *  occur during the Hash Value Generation Process.
     * 
     *  @param value        A String Containing the
     *                      type of Exception that
     *                      has occurred during the
     *                      Hash Value Generation Process.
     */
    public void setExceptionType(String value) {
        // Set Exception Type.
        this.exception = value;
    }
 }
