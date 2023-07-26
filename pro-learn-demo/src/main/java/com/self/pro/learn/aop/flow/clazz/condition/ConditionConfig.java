package com.self.pro.learn.aop.flow.clazz.condition;

import com.self.pro.learn.aop.flow.clazz.abstra.AbstractUser;
import com.self.pro.learn.aop.flow.clazz.abstra.BlUser;
import com.self.pro.learn.aop.flow.clazz.abstra.MxgUser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

	//@Bean
//	@Conditional(WindowsCondition.class)
    //@ConditionalOnProperty(prefix = "mxg", name = "user", havingValue = "true", matchIfMissing = true)
	//@ConditionalOnExpression("true")
//	@ConditionalOnExpression("'${mxg.user}'.equals('true')")
	public AbstractUser windowsListUser() {
		return new MxgUser();
	}

	//@Bean
	//@Conditional(LinuxCondition.class)
//	@ConditionalOnProperty(prefix = "mxg", name = "user", havingValue = "true", matchIfMissing = true)
	public AbstractUser linuxListUser() {
		return new BlUser();
	}
}

