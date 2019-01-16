
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class RaceResultServiceTest {


    RaceResultService raceResultService = new RaceResultService();

    Client clientA = mock(Client.class, "clientA");
    Client clientB = mock(Client.class, "clientB");
    Message message = mock(Message.class);
    @Test
    public void subscribedClientShouldReceiveMessages()
    {
        //arrange


        //act
        raceResultService.addSubscriber(clientA);
        raceResultService.sendMessage(message);

        //assert
        verify(clientA).receiveMessage(message);
    }

    @Test
    public void sendMessageToMultipleClients()
    {


        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientB);
        raceResultService.sendMessage(message);

        verify(clientA).receiveMessage(message);
        verify(clientB).receiveMessage(message);
    }

    @Test
    public void notSubscribedClientsShouldNotReceiveMessages()
    {
        raceResultService.sendMessage(message);

        verify(clientA, never()).receiveMessage(message);
        verify(clientB, never()).receiveMessage(message);
    }


    @Test
    public void testIfOneClientCanSubscribeTwoTime()
    {
        raceResultService.addSubscriber(clientA);
        raceResultService.addSubscriber(clientA);
        raceResultService.sendMessage(message);

        verify(clientA).receiveMessage(message);
    }

    @Test
    public void testIfRemovedSubscriberReceivesMessages()
    {
        raceResultService.addSubscriber(clientA);
        raceResultService.removeSubscriber(clientA);
        raceResultService.sendMessage(message);
        verify(clientA, never()).receiveMessage(message);
    }


}
