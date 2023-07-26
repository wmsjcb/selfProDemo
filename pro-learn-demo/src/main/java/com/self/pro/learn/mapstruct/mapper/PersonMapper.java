package com.self.pro.learn.mapstruct.mapper;

import com.self.pro.learn.mapstruct.bean.Person;
import com.self.pro.learn.mapstruct.mul.bean.BasicEntity;
import com.self.pro.learn.mapstruct.bean.PersonDTO;
import com.self.pro.learn.mapstruct.bean.PersonEntry;
import com.self.pro.learn.mapstruct.util.DateFormtUtil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DateFormtUtil.class, componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCT = Mappers.getMapper(PersonMapper.class);
    @Mappings({
//            @Mapping(target = "age", source = "age"),

//             @Mapping(target = "name", source = "personName"),
            @Mapping(target = "personName", source = "name"),
            @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
    })
    PersonDTO conver(Person person);



    @Mappings({
//            @Mapping(target = "createTime" ,source = "createTime", dateFormat = "yyyy-MM-dd"),
            //默认日期
           // @Mapping(target = "createTime",expression = "java(new java.util.Date())"),
            //默认值
            @Mapping(target = "describe", source = "describe", defaultValue = "default"),
            @Mapping(target = "personName", source = "name")
//            @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
    })
    PersonDTO converToEntry(PersonEntry person);

    @Mappings({
            @Mapping(target = "createTime",source = "basicEntity.createTime")
    })
    PersonDTO combinationConver(Person personC, BasicEntity basicEntity);

    @Mapping(target = "id", source = "id")
    PersonDTO mapTo(Person person, String id);

    @Mappings({
            @Mapping(target = "child", source = "personChild")
    })
    PersonDTO converChild(Person person);

   //继承相应反向方法的反向配置
//   @InheritInverseConfiguration
//    @Mappings({
//            @Mapping(target = "name", source = "personName"),
//            @Mapping(target = "personChild", source = "child"),
//            @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
//    })
//    Person converInverse(PersonDTO dto);


    @Mappings({
//            @Mapping(target = "createTime" ,source = "createTime", dateFormat = "yyyy-MM-dd"),
            //默认日期
            // @Mapping(target = "createTime",expression = "java(new java.util.Date())"),
            //默认值
            @Mapping(target = "describe", source = "describe", defaultValue = "default"),
            @Mapping(target = "personName", source = "name")
//            @Mapping(target = "id", ignore = true) // 忽略id，不进行映射
    })
    List<PersonDTO> converToEntrys(List<PersonEntry> persons);

}