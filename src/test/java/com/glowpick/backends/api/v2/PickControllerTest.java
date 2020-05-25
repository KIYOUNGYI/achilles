package com.glowpick.backends.api.v2;

import com.glowpick.services.PickService;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PickControllerTest
{
    @Mock
    PickService pickService;
}
