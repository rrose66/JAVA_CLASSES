package utilities;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class InputParams 
{
//	public static void main(String[] args) 
//	{
//		Logger logger = Logger.getLogger(InputParams.class);
//		
//		final Properties properties = getProperties();
//		
//		final String mode = properties.getProperty("FEDEBOM.mode");
//		final String env = properties.getProperty("FEDEBOM.env");
//		final String wslCookie = properties.getProperty("FEDEBOM.wslCookie");
//		final String retrieveEndpointurl = properties.getProperty(mode + "." + env + ".endpointUrl");
//		final String userId = System.getProperty("user.name");
//		static String cdsId = System.getProperty("user.name");
//
//		static String hostname = getCdsIdHostName(cdsId);
//		Map<String,String> location =new HashMap<String,String>();
//		String selectedRole=null;
//		List<String> roles=null;
//		private String userEmploymentType = null;
//		private String userName = "";
//		final String cdsId_hostname = hostname == null ? cdsId : (cdsId + "_" + hostname);
//		public static boolean validateProperties(InputParams inputParams) 
//		{
//			return (inputParams.getMode() != null && !inputParams.getMode().isEmpty()) && (inputParams.getEnv() != null && !inputParams.getEnv().isEmpty())
//					&& (inputParams.getWslCookie() != null && !inputParams.getWslCookie().isEmpty())
//					&& (inputParams.getRetrieveEndpointurl() != null && !inputParams.getRetrieveEndpointurl().isEmpty());
//		}
//
//		private static Properties getProperties() 
//		{
//			final Properties properties = new Properties();
//			InputStream input = null;
//			try 
//			{
//				input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
//				properties.load(input);
//				logger.info("application.properties loaded");
//			} 
//			catch (final IOException e) 
//			{
//				logger.error("Error: reading application.properties failed.");
//				logger.error(e.getMessage());
//			} 
//			finally 
//			{
//				if (input != null)
//				{
//					try 
//					{
//						input.close();
//					} 
//					catch (final IOException e) 
//					{
//						logger.error(e.getMessage());
//					}
//				}
//			}
//			return properties;
//		}
//		
//		private static String getCdsIdHostName(String cdsId)
//		{
//			 try 
//			 {
//		            hostname = InetAddress.getLocalHost().getHostName();
//		        } 
//			 catch (final UnknownHostException e) 
//			 {
//		            e.printStackTrace();
//		        }
//			return hostname;
//			
//		}
//		
//		public String getUserName() 
//		{
//			return userName;
//		}
//
//		public void setUserName(String userName) 
//		{
//			this.userName = userName;
//		}
//
//		public String getUserEmploymentType() 
//		{
//			return userEmploymentType;
//		}
//
//		public void setUserEmploymentType(String userEmploymentType) 
//		{
//			this.userEmploymentType = userEmploymentType;
//		}
//
//		public String getHostname() 
//		{
//			return hostname;
//		}
//
//		public String getMode() 
//		{
//			return mode;
//		}
//
//		public String getEnv() 
//		{
//			return env;
//		}
//
//		public String getWslCookie() 
//		{
//			return wslCookie;
//		}
//
//		public String getRetrieveEndpointurl() 
//		{
//			return retrieveEndpointurl;
//		}
//
//		public String getUserId() 
//		{
//			return userId;
//		}
//
//		public String getCdsId_hostname() 
//		{
//			return cdsId_hostname;
//		}
//
//		public String getSelectedRole() 
//		{
//			return selectedRole;
//		}
//
//		public void setSelectedRole(String selectedRole) 
//		{
//			this.selectedRole = selectedRole;
//		}
//
//		public List<String> getRoles() 
//		{
//			return roles;
//		}
//
//		public void setRoles(List<String> roles) 
//		{
//			this.roles = roles;
//		}
//		
//		public Map<String, String> getLocation() 
//		{
//			return location;
//		}
//
//
//
//	}

}
