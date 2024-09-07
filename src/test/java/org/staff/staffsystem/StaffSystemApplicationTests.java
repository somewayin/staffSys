package org.staff.staffsystem;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class StaffSystemApplicationTests {

    @Test
    public void testUuid(){
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","admin");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "zekenwang")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("zekenwang")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzI1NzMyNzg5LCJ1c2VybmFtZSI6ImFkbWluIn0.aNpRSC8SVUX25fnfWCBnhEsLHDN3BRxn-3qlp0GinkI")
                .getBody();
        System.out.println(claims);
    }
}
