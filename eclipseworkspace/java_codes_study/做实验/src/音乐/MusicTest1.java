package “Ù¿÷;
import javax.sound.midi.*;
public class MusicTest1 {
	public void play()
	{
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("we got a sequencer");
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("error");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}

}
