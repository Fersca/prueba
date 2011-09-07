import grails.util.Environment;

class PSE {

	static def appName = getAppName()
	
	static def getAppName(){

		if (Environment.current == Environment.PRODUCTION){
			return "PSE-0.1"
		} 
		
		return "PSE"
						
	}
	
}
