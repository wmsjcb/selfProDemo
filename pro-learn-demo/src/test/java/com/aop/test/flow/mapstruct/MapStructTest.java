package com.aop.test.flow.mapstruct;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.mapstruct.bean.Child;
import com.self.pro.learn.mapstruct.bean.Person;
import com.self.pro.learn.mapstruct.bean.PersonDTO;
import com.self.pro.learn.mapstruct.bean.PersonEntry;
import com.self.pro.learn.mapstruct.mapper.PersonMapper;
import com.self.pro.learn.mapstruct.mul.bean.BasicEntity;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class MapStructTest {
    @Autowired
    PersonMapper personMapper;

    @Test
    public void test(){
        Person person = new Person();
        person.setDescribe("test");
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));

        val dto = PersonMapper.INSTANCT.conver(person);

        System.out.println(dto);
        // PersonDTO(describe=测试, id=null, personName=张三, age=18, source=100, height=170.5)
    }

    @Test
    public void testEntry(){
        PersonEntry person = new PersonEntry();
        person.setId("1");
//        person.setDescribe("test");
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        person.setCreateTime(new Date());

        PersonDTO dto = PersonMapper.INSTANCT.converToEntry(person);
        System.out.println(dto);
    }

    @Test
    public void testMulEntry(){
        Person person = new Person();
        person.setId("1");
//        person.setDescribe("test");
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
//        person.setCreateTime(new Date());

        BasicEntity basicEntity = new BasicEntity();
        basicEntity.setCreateTime(new Date());

        PersonDTO dto = PersonMapper.INSTANCT.combinationConver(person,basicEntity);
        System.out.println(dto);
    }

    @Test
    public void testId(){
        Person person = new Person();
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        PersonDTO dto = PersonMapper.INSTANCT.mapTo(person,"500");
        System.out.println(dto);
    }

    @Test
    public void testChild(){
        Person person = new Person();
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        Child child = new Child();
        child.setCounty("mxg");
        person.setPersonChild(child);
        PersonDTO dto = PersonMapper.INSTANCT.converChild(person);
        System.out.println(dto);
    }
//    @Test
//    public void testInverse(){
//        PersonDTO person = new PersonDTO();
//        person.setDescribe("test");
//        person.setAge("18");
//        person.setPersonName("zhangsan");
//        person.setHeight("170.5");
//        person.setSource("100");
//        Child child = new Child();
//        child.setCounty("mxg");
//        person.setChild(child);
//        Person pson = PersonMapper.INSTANCT.converInverse(person);
//        System.out.println(pson);
//    }

    @Test
    public void testSpring(){
        Person person = new Person();
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        Child child = new Child();
        child.setCounty("mxg");
        person.setPersonChild(child);
        PersonDTO dto = personMapper.converChild(person);
        System.out.println(dto);
    }

    @Test
    public void testEntrys(){
        List<PersonEntry> entries = new ArrayList<>();

        PersonEntry person = new PersonEntry();
        person.setId("1");
//        person.setDescribe("test");
        person.setAge(18);
        person.setName("zhangsan");
        person.setHeight(170.5);
        person.setSource(new BigDecimal("100"));
        person.setCreateTime(new Date());
        entries.add(person);
        List<PersonDTO> personDTOS = personMapper.converToEntrys(entries);
        System.out.println(personDTOS);
    }
}