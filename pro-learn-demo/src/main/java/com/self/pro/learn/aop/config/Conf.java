package com.self.pro.learn.aop.config;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "switch")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Conf {
    @XmlElement(name="whitelist")
    private List<String> whitelist;
    @XmlAttribute(name = "isopen")
    private boolean isopen;
    @XmlAttribute(name = "iswhite")
    private boolean iswhite;

}