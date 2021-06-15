package com.maul.tugas10;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CommandLine commandLine=new CommandLine();
		try {			
			commandLine.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Don't Input Character!!");
			main(null);
		}
    }
}
