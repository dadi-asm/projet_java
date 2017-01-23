
package javaapplication1;


abstract public class SpongeHeader{
    
  //  protected int BLOCKS_LEN_BYTES = /*Byte.SIZE */ 96;
    abstract void squeeze(byte state[],byte out[], int len);
    //abstract void reducedSqueezeRow0(byte state[],byte rowOut[]);
}
