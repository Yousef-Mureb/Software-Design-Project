public class Message {
	Subject origin;
	String topic;
	String payload;

	public Message(Subject instance, String topic, String payload){
		this.origin=instance;
		this.topic=topic;
		this.payload=payload;
	}
	
//	public Message(Watch instance, String topic, String payload){
//		origin=(Object) instance;
//		this.topic=topic;
//		this.payload=payload;
//	}

	public String toString() {
		return "origin:"+origin+"\ntopic:"+topic+"\npayload:"+payload;
	}
}
