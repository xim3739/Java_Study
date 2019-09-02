package example19;

public class VideoPlayer implements controllable{
	@Override
	public void play() {
		System.out.println("videoPalyer Play!!!");
	}
	@Override
	public void stop() {
		System.out.println("videoPlayer Stop!!!");
	}
}
