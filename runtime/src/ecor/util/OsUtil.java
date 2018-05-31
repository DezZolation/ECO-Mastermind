package ecor.util;

public class OsUtil {
	
	public static OsType getOsType() {
		
		return OsType.VEM;
		
		/*String osName = System.getProperty("os.name");
		System.out.println("os.name: " + osName);
		
		if (isWindowsVariant(osName)) {
			return OsType.WINDOWS;
		}
		
		if (isUnixVariant(osName)) {
			String vendor = System.getProperty("java.vendor");
      System.out.println("Vendor: " + vendor);
			
			if (vendor.equals("The Android Project")) {
				return OsType.ANDROID;
			}
			
			return OsType.LINUX;
		}
		
		return OsType.NONE;*/
	}
	
	private static boolean isWindowsVariant(String osName) {
		return (osName.equals("Windows 7") ||
				osName.equals("Windows XP") ||
				osName.equals("Windows 2003") ||
				osName.equals("Windows NT") ||
				osName.equals("Windows 8.1"));
	}
	
	private static boolean isUnixVariant(String osName) {
		return (osName.equals("Linux") || osName.equals("Mac OS X"));
	}
	
}
