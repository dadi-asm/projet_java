package javaapplication1;
import java.math.BigInteger;


public class Sponge extends SpongeHeader implements Lyrae2Header
{
    
    public static void spongeLyra(byte[] v)
    {
   
    }
    
    /**
 * Executes a reduced version of Blake2b's G function with only one round
 * @param v     A 1024-bit (16 uint64_t) array to be processed by Blake2b's G function
 */
    static void reducedBlake2bLyra(byte v[]) 
    {
        ROUND_LYRA(0);
    }
    public void squeeze(byte state[],byte outt[],int len)//unsigned int
    {
        int fullBlocks=len/BLOCKS_LEN_BYTES;
       
        for(int i=0;i<fullBlocks;i++)
        {
            for(int j=i*BLOCKS_LEN_BYTES;j<BLOCKS_LEN_BYTES*(i+1);j++){
                outt[j]=state[j];
            }
            spongeLyra(state);
        }
         //Squeezes remaining bytes
        for(int j=fullBlocks;j<fullBlocks+len%BLOCKS_LEN_BYTES;j++)
        {
                outt[j]=state[j];
        }
        
    }
    
 /* @param state     The current state of the sponge 
 * @param row       Row to receive the data squeezed
 */
    void reducedSqueezeRow(byte state[],byte row[]) 
    {
    int i,j=0;
    //M[row][col] = H.reduced_squeeze()
        for (i = j*N_COLS; i < N_COLS*(j+1); i++) 
        {
            row[0] = state[0];
            row[1] = state[1];
            row[2] = state[2];
            row[3] = state[3];
            row[4] = state[4];
            row[5] = state[5];
            row[6] = state[6];
            row[7] = state[7];
            row[8] = state[8];
            row[9] = state[9];
            row[10] = state[10];
            row[11] = state[11];

            //Goes to next block (column) that will receive the squeezed data
            //row += BLOCK_LEN_INT64;
            j++;
            //Applies the reduced-round transformation f to the sponge's state
            reducedBlake2bLyra(state);
        }
}
    
}
