package org.staff.staffsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class StaffSystemApplicationTests {

    @Test
    public void testUuid(){
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

}
