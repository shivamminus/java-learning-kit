class Client
{
	java.net.Socket s;
	java.io.ObjectInputStream obis;
	java.io.ObjectOutputStream obos;

	Client()
	{
		try
		{
			s=new java.net.Socket("localhost", 3304);
			System.out.println("connected to server");
			Thread reader=new Thread()
			{
				public void run()
				{
					while(true)
					{
						try
						{	
							obis=new java.io.ObjectInputStream(s.getInputStream());
							String msg=obis.readObject()+"";
							System.out.println(msg);
						}	
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			};	
			Thread writer=new Thread()
			{
				public void run()
				{
					try
					{		
						while(true)
						{	
							obos=new java.io.ObjectOutputStream(s.getOutputStream());
							String msg="Client: "+new java.util.Scanner(System.in).nextLine();
							obos.writeObject(msg);
							obos.flush();
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			};
			
			reader.start();
			writer.start();	
		}
		catch(Exception r)
		{
			r.printStackTrace();
		}	
		
	}
	public static void main(String ramup[])
	{
		new Client(); 		
	}
}
