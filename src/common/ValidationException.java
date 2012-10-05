/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author RVAFOD
 */
public class ValidationException extends Exception{

    public ValidationException(String errorMessage){
        super(errorMessage);
    }
}
