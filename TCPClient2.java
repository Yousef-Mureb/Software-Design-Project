import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.lang.Math;

public class TCPClient2 implements Runnable {

	String host = "192.168.1.12";
	int port = 53050;
	JSONParser parser;
	double aggMag = 0;
	Thread t;

	public TCPClient2() {
		t = new Thread(this);
		t.start();
	}

	/*
	 * )public TCPClient2(String host, int port){ this.host = host; this.port =
	 * port; Thread t = new Thread(this); t.start(); }
	 */

	private boolean slice = false, spray = false, pour = false, mix = false, slide = false, clap = false, Punch = false;

	public synchronized boolean isMix() {
		return mix;
	}

	public synchronized boolean isClap() {
		return clap;
	}

	public synchronized void setClap(boolean clap) {
		this.clap = clap;
	}

	public synchronized void setMix(boolean mix) {
		this.mix = mix;
	}

	public synchronized boolean isSpray() {
		return spray;
	}

	public synchronized void setPunch(boolean Punch) {
		this.Punch = Punch;

	}



	public synchronized void setSpray(boolean spray) {
		this.spray = spray;
	}

	public synchronized boolean isSlice() {
		return slice;
	}

	public synchronized void setSlice(boolean slice) {
		this.slice = slice;
	}

	public synchronized boolean isPour() {
		return pour;
	}

	public synchronized void setPour(boolean pour) {
		this.pour = pour;
	}

	public synchronized boolean isSlide() {
		return slide;
	}

	public synchronized boolean isPunch() {
		return Punch;
	}



	public synchronized void setSlide(boolean slide) {
		this.slide = slide;
	}

	@Override

	public void run() {
		parser = new JSONParser();
		try {
			try (Socket socket = new Socket(this.host, this.port)) {
				InputStream input = socket.getInputStream();
				InputStreamReader reader = new InputStreamReader(input);

				//-------------------------------- new reader -------------------------------
				BufferedReader br = new BufferedReader(reader);
				String line = "";
				while ((line = br.readLine()) != null) {//read line by line
					//print what you received
					//UI.print(line);
					//parse String to JSON
					JSONObject jsonObject = (JSONObject) parser.parse(line);
					//print the object
					//System.out.println(jsonObject);//**For Android see section at the end of the script
					//select a specific value using its key



					String Zvalue = (String) jsonObject.get("accelerometerAccelerationZ");
					String Xvalue = (String) jsonObject.get("accelerometerAccelerationX");
					String Yvalue = (String) jsonObject.get("accelerometerAccelerationY");
					double accZ = Double.parseDouble(Zvalue);
					double accY= Double.parseDouble(Yvalue);
					double accX = Double.parseDouble(Xvalue);

					aggMag= Math.sqrt((accZ*accZ)+(accX*accX)+(accY*accY));



					String locHeading = (String) jsonObject.get("locationTrueHeading");
					double heading= Double.parseDouble(locHeading);
					String Zgyro = (String) jsonObject.get("gyroRotationZ");
					String Xgyro = (String) jsonObject.get("gyroRotationX");
					String Ygyro = (String) jsonObject.get("gyroRotationY");



					double gyroX= Double.parseDouble(Xgyro);
					double gyroY= Double.parseDouble(Ygyro);
					double gyroZ= Double.parseDouble(Zgyro);


					String soundPeak = (String) jsonObject.get("avAudioRecorderPeakPower");



					double peakSound= Double.parseDouble(soundPeak);

					// values for chopping chocolate:

					//y: 0-> -0.3
					// x: -0.9 -> -2
					//z: -0.1 -> -0.6


					//x values for punch 1-2   
					//y reaches 3, start 2
					// for z 1-1.5


					//						
					if(accZ<=-0.1 && accZ>=-1	&& accY<=0 && accY>=-0.5 && accX>= -3 && accX<=-0.9) //maybe not start at 0 f ure getting errs with others
					{
						//UI.print("You are chopping correctly! ");

						setSlice(true);


					}

					if(heading<=100 || heading>=300){

						setPour(true);
					}
					//						
					//						
					//						

					if(((gyroZ>=2 && gyroZ<=5) || (gyroZ<=-3 && gyroZ>=-7)) && ((gyroX>=4 && gyroX<=8) || (gyroX<=-4 && gyroX>=-8)) && ((gyroY>=3 && gyroY<=7) || (gyroY<=-2 && gyroZ>=-5))){

						//UI.print("Whisk is used! ");
						setMix(true);
					}



					if(accX<=0.5 && accX>=-0.5 && accY>=0.2 && accY<=0.5 && accZ<=-0.5 && accZ>=-1.5  ){

						setSlide(true);
					}
					//						
					//						
					//						//x values for punch 1-2   
					//						//y reaches 3, start 2
					//						// for z 1-1.5




					if(aggMag>2.5 && aggMag<=10.0  ){

						setPunch(true);

					}


					//					t.sleep(10);

					//values for adding ingredients:
					//						//



					if(peakSound>=-0.9){
						//UI.print("WEEE");
						setClap(true);
					}

					//print the selected value
					//UI.print("Logging time is: "+logTime);
				}
				//----------------------------------------------------------------------------


			}

		} catch (UnknownHostException ex) {

		} catch (IOException ex) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
