package controller;
import java.io.*;

public class KillController 
{
	public KillController()
	{
	super();	
	}
	

public void os()
 {
  String os = System.getProperty("os.name");
  System.out.println(os);
  
  String proW = "TASKLIST /FO TABLE";
  String proL = "ps -ef";
  
  if (os.contains("Windows "))
  {
	 readProcess(proW); 
  } else 
    {
	  readProcess(proL); 
    }
 }

public void callProcess(String proc)
{
 String[]procVet = proc.split(" ");
 try
 {
  Runtime.getRuntime().exec(procVet); 
 }catch (Exception e)
  {
   String msg = e.getMessage();
   if (msg.contains("740"))
   {
	StringBuffer buffer = new StringBuffer();
	buffer.append("cmd /c");
	buffer.append(" ");
	buffer.append(proc);
	try
	{
	 String[]procvet1 = buffer.toString().split(" ");
	 Runtime.getRuntime().exec(procvet1);	
	}catch (Exception e1)
	 {
	  System.err.println(e1.getMessage());
	 } 
   } else
	  {
	   System.err.println(msg); 
	  }
  }	 
 }	
public void matarProcess(String valor)
{
	String cmdPID = "TASKKILL /PID";
	String cmdNAME = "TASKKILL /IM";
	StringBuffer buffer = new StringBuffer();
	
	int pid = 0;
	
	try
	{
	pid = Integer.parseInt(valor);
	buffer.append(cmdPID);
	buffer.append(" ");
	buffer.append(pid);
	} catch (Exception e)
	 {
		buffer.append(cmdNAME);
		buffer.append(" ");
		buffer.append(valor);
	 } 
	
	String matar = buffer.toString();
	callProcess(matar);
	
	
    }
	public void readProcess(String proc)
	{
	 String[] procvt = proc.split(" ");
	 try 
	 {
	  Process p = Runtime.getRuntime().exec(procvt);
	  InputStream fluxo = p.getInputStream();
	  InputStreamReader ler = new InputStreamReader(fluxo);
	  BufferedReader buffer = new BufferedReader(ler);
	  String linha = buffer.readLine();
	  while (linha != null)
	  {
		   
			System.out.println(linha); 
			linha = buffer.readLine();
			}
	   
	  buffer.close();
	  ler.close();
	  fluxo.close();
	 } catch (Exception e)
	   {
		System.out.println(""); 
	   }
	

}

}

