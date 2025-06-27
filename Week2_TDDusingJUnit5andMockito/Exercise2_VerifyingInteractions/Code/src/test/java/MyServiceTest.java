
import org.junit.jupiter.api.Test;
import org.saptarshi.ExternalApi;
import org.saptarshi.MyService;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock of ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Inject mock into MyService
        MyService service = new MyService(mockApi);

        // 3. Call method
        service.fetchData();

        // 4. Verify that getData() was called
        verify(mockApi).getData();
    }
}
