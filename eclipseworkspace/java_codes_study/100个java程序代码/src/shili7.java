interface player{
	int flag=1;
	void play();
	void pause();
	void stop();
	
}
abstract class playing
{
	public void display(Object oPara){
		System.out.println(oPara);
	}
	abstract void winRun();
}
class newPlay extends playing implements player
{
	public void play()
	{
		display("newPlay.play()");
	}
	public void pause()
	{
		display("newPlay.pause()");
	}
	public void stop()
	{
		display("newPlay.stop()");
	}
	void winRun()
	{
		display("newPlay.winRun()");
	}
}
public class shili7 {

	public static void main(String[] args) {
		newPlay p = new newPlay();
		p.play();
		p.pause();
		p.stop();
		p.winRun();
	}

}
