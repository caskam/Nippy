
import java.io.*;
import java.util.Scanner;

public class Nippy {
	public static void main(String args[]) {
		try {
			final MessageHandler irc = new MessageHandler("chat.freenode.net", 6667, "nippy-client");
			irc.join("#nippy");
			String line = null;
			
			while ((line = irc.getMessage()) != null) {
				System.out.println(line);
				if(line.startsWith("PING ")) {
					irc.message("PING " + line.substring(5));
				}
				int secondColon = line.indexOf(':', 1);
				//System.out.println("secondcolon " + secondColon);
				if(line.contains("!")) {
					int nickEnd = line.indexOf('!');
					//System.out.println("nickend " + nickEnd);
					if(nickEnd < secondColon) {
						nickEnd = line.indexOf('!');
						String message = line.substring(secondColon);
						System.out.println(line.substring(1, nickEnd) + " " + message);
					}
				} else if(secondColon != -1) {
					String message = line.substring(secondColon);
					System.out.println(message);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           );
					System.out.println(message);
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
