import java.util.Scanner;
import java.io.*;
public class Main{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        //Input DATA
        System.out.println("Enter Message/Data bits");
        String message = in.nextLine();
        System.out.println("Enter Generator");
        String generator = in.nextLine();
        int data[] = new int[message.length()+generator.length()-1];
        int divisor[] = new int[generator.length()];
        for(int i=0; i<message.length(); i++)
        {
            data[i]=Integer.parseInt(message.charAt(i)+""); 
        }
        for(int i=0; i<generator.length(); i++)
        {
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");
        }
        
        //CRC calculation
        for(int i=0; i<message.length(); i++)
        {
            if(data[i]==1)  //if 0, you can just skip
                for(int j=0; j<divisor.length; j++) 
                    data[i+j]^=divisor[j];
        }
        //Display CRC
        System.out.println("The checksum code is: ");
        for(int i=0; i<message.length();i++)
            data[i]=Integer.parseInt(message.charAt(i)+"");
        for(int i=0; i<data.length; i++)
            System.out.print(data[i]);
        System.out.println();
        
        //CHECK for input CRC code
        System.out.println("Enter Checksum code");
            message=in.nextLine();
        System.out.println("Enter generator");
            generator=in.nextLine();
        data = new int[message.length()+generator.length()-1];
        divisor = new int[generator.length()];
        for(int i=0; i<message.length();i++)
            data[i] = Integer.parseInt(message.charAt(i)+"");
        for(int i=0; i<generator.length();i++)
            divisor[i] = Integer.parseInt(generator.charAt(i)+"");
            
        //Calculator of remainder
        for(int i=0; i<message.length(); i++)
        {
            if(data[i]==1)
                for(int j=0; j<divisor.length; j++)
                    data[i+j]^=divisor[j];
        }
        
        //validity of data
        boolean valid = true;
        for(int i=0; i<data.length;i++)
            if(data[i] == 1){
                valid = false;
                break;
            }
            if(valid == true)
            {
                System.out.println("Data stream is valid");
            } else {
                System.out.println("Data stream is not valid, CRC error");
            }

    }
}
