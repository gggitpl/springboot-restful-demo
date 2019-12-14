package com.example.restful.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author gggitpl
 */
public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static GlobalConfig globalConfig() {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("gggitpl");
        gc.setServiceName("%sService");
        gc.setFileOverride(false);
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setFileOverride(false);
        return gc;
    }

    public static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.0.8:3306/test_db?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("abc123");
        return dsc;
    }

    public static PackageConfig packageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.restful");
        pc.setEntity("model");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        pc.setXml("xml");
        return pc;
    }

    public static StrategyConfig strategyConfig(PackageConfig pc) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix("t_");
        strategy.setSuperEntityClass("com.example.restful.common.BaseEntity");
        strategy.setSuperEntityColumns("id", "create_time", "update_time", "deleted");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.example.restful.common.BaseController");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }

    public static InjectionConfig injectionConfig() {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        return cfg;
    }

    public static TemplateConfig templateConfig() {
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        return tc;
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig());
        mpg.setDataSource(dataSourceConfig());
        mpg.setPackageInfo(packageConfig());
        mpg.setStrategy(strategyConfig(packageConfig()));
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setCfg(injectionConfig());
        mpg.setTemplate(templateConfig());
        mpg.execute();
    }


}
