package com.cloverfew.mybatis_gen;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.mybatis.generator.internal.ObjectFactory;
import org.sqlite.jdbc4.JDBC4Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * @author yunzz
 */
public class MapperPlugin extends PluginAdapter {

    private static final String DEFAULT_DAO_SUPER_CLASS = "com.fendo.mapper.BaseMapper";

    private static final String DEFAULT_EXPAND_DAO_SUPER_CLASS = "com.fendo.mapper.BaseExpandMapper";

    private String daoTargetDir;

    private String daoTargetPackage;

    private String daoSuperClass;

    private String moduleInterface;

    private String preFix;

    private boolean spring;

    // 扩展
    private String expandDaoTargetPackage;

    private String expandDaoSuperClass;

    private ShellCallback shellCallback = null;

    private final String QeuryName = "Query";

    public MapperPlugin() {
        shellCallback = new DefaultShellCallback(false);
    }

    /**
     * 验证参数是否有效
     *
     * @param warnings
     * @return
     */
    @Override
    public boolean validate(List<String> warnings) {
        daoTargetDir = properties.getProperty("targetProject");
        boolean valid = stringHasValue(daoTargetDir);

        daoTargetPackage = properties.getProperty("targetPackage");
        boolean valid2 = stringHasValue(daoTargetPackage);

        daoSuperClass = properties.getProperty("daoSuperClass");
        if (!stringHasValue(daoSuperClass)) {
            daoSuperClass = DEFAULT_DAO_SUPER_CLASS;
        }
        preFix = properties.getProperty("preFix");
        if (!stringHasValue(preFix)) {
            preFix = "";
        }

        expandDaoTargetPackage = properties.getProperty("expandTargetPackage");
        expandDaoSuperClass = properties.getProperty("expandDaoSuperClass");
        if (!stringHasValue(expandDaoSuperClass)) {
            expandDaoSuperClass = DEFAULT_EXPAND_DAO_SUPER_CLASS;
        }
        moduleInterface = properties.getProperty("moduleInterface");

        spring = Boolean.parseBoolean(properties.getProperty("spring"));


        return valid && valid2;
    }


    /**
     * 生成mapping 添加自定义sql
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        //创建Select查询
        XmlElement select = new XmlElement("select");
        select.addAttribute(new Attribute("id", "selectAll"));
        select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        select.addElement(new TextElement("select * from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));


        XmlElement parentElement = document.getRootElement();
        parentElement.addElement(select);
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        JavaFormatter javaFormatter = context.getJavaFormatter();
        String baseName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        List<GeneratedJavaFile> mapperJavaFiles = new ArrayList<>();
        Map<String, GeneratedJavaFile> fileMap = new HashMap<>();

        String entity = baseName;
        String example = baseName + "Example";
        String mapping = baseName + "Mapper";

        String queryName = baseName + QeuryName;
        String SqlName = baseName + "Sql";

        String mappingName = daoTargetPackage + "." + this.preFix + baseName + "Mapper";

        for (GeneratedJavaFile javaFile : introspectedTable.getGeneratedJavaFiles()) {
            fileMap.put(javaFile.getCompilationUnit().getType().getShortName(), javaFile);
        }


        // GenMapping
//        GeneratedJavaFile mappingJavaFile = fileMap.get(baseName);
//        Interface mapperInterface = new Interface(mappingName);
//        List<IntrospectedColumn> introspectedColumns = introspectedTable
//                .getPrimaryKeyColumns();
//        mapperInterface.setVisibility(JavaVisibility.PUBLIC);
//        FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(daoSuperClass);
//        // 添加泛型支持
//        daoSuperType.addTypeArgument(introspectedColumns.get(0).getFullyQualifiedJavaType());
//        FullyQualifiedJavaType baseModelJavaType = mappingJavaFile.getCompilationUnit().getType();
//        daoSuperType.addTypeArgument(baseModelJavaType);
//        mapperInterface.addSuperInterface(daoSuperType);
//        mapperJavaFiles.add(new GeneratedJavaFile(mapperInterface, daoTargetDir, javaFormatter));

        // todo
        // sql
//        sqlFile(javaFormatter, baseName, mapperJavaFiles, mappingName, queryName, SqlName, example, introspectedTable.hasBLOBColumns());

        // todo
        // query
//        createQueryFile(fileMap.get(baseName), fileMap.get(example), javaFormatter, baseName, mapperJavaFiles, queryName, SqlName, example, introspectedTable.hasBLOBColumns());

        return mapperJavaFiles;
    }

    private void sqlFile(JavaFormatter javaFormatter, String baseName, List<GeneratedJavaFile> mapperJavaFiles, String mappingName, String queryName, String sqlName, String exampleName, boolean hasBlob) {
        TopLevelClass sqlClass = new TopLevelClass(daoTargetPackage + "." + sqlName);
        sqlClass.setVisibility(JavaVisibility.PUBLIC);

        // field
        FullyQualifiedJavaType daoSuperType = new FullyQualifiedJavaType(mappingName);
        Field sqlField = new Field("mapper", daoSuperType);
        sqlField.setVisibility(JavaVisibility.PRIVATE);
        sqlField.setType(daoSuperType);
        sqlField.setName("mapper");
        if (spring) {
            sqlField.addAnnotation("@Autowired");
        }
        sqlClass.addField(sqlField);

        // method
        Method createM = new Method("q");
        createM.setVisibility(JavaVisibility.PUBLIC);
        FullyQualifiedJavaType createReturn = new FullyQualifiedJavaType(queryName);
        createM.setReturnType(createReturn);
        createM.addBodyLine(String.format("return new %s(this);", queryName));
        sqlClass.addMethod(createM);

        Method listM = new Method("list");
        listM.setVisibility(JavaVisibility.PUBLIC);
        createReturn = new FullyQualifiedJavaType("List");
        createReturn.addTypeArgument(new FullyQualifiedJavaType(baseName));
        listM.setReturnType(createReturn);
        Parameter p1 = new Parameter(new FullyQualifiedJavaType(exampleName), "example");
        listM.addParameter(p1);
        listM.addBodyLine(String.format("return mapper.selectByExample(example);"));
        sqlClass.addMethod(listM);

        if (hasBlob) {
            Method listWidthBlobM = new Method("listWithBlob");
            listWidthBlobM.setVisibility(JavaVisibility.PUBLIC);
            createReturn = new FullyQualifiedJavaType("List");
            createReturn.addTypeArgument(new FullyQualifiedJavaType(baseName));
            listWidthBlobM.setReturnType(createReturn);
            Parameter p2 = new Parameter(new FullyQualifiedJavaType(exampleName), "example");
            listWidthBlobM.addParameter(p2);
            listWidthBlobM.addBodyLine(String.format("return mapper.selectByExample(example);"));
            sqlClass.addMethod(listWidthBlobM);
        }

        Method method = new Method("delete");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        Parameter param = new Parameter(new FullyQualifiedJavaType(exampleName), "example");
        method.addParameter(param);
        method.addBodyLine(String.format("return mapper.deleteByExample(example);"));
        sqlClass.addMethod(method);

        method = new Method("insert");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        param = new Parameter(new FullyQualifiedJavaType(baseName), "value");
        method.addParameter(param);
        method.addBodyLine(String.format("return mapper.insert(value);"));
        sqlClass.addMethod(method);

        method = new Method("insertSelective");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        param = new Parameter(new FullyQualifiedJavaType(baseName), "value");
        method.addParameter(param);
        method.addBodyLine(String.format("return mapper.insert(value);"));
        sqlClass.addMethod(method);

        method = new Method("update");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "record"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(exampleName), "example"));
        method.addBodyLine(String.format("return mapper.updateByExample(record, example);"));
        sqlClass.addMethod(method);

        if (hasBlob) {
            method = new Method("updateWithBLOBs");
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(new FullyQualifiedJavaType("int"));
            method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "record"));
            method.addParameter(new Parameter(new FullyQualifiedJavaType(exampleName), "example"));
            method.addBodyLine(String.format("return mapper.updateByExampleWithBLOBs(record, example);"));
            sqlClass.addMethod(method);
        }

        method = new Method("updateSelective");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "record"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(exampleName), "example"));
        method.addBodyLine(String.format("return mapper.updateByExampleSelective(record, example);"));
        sqlClass.addMethod(method);

        method = new Method("count");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("long"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(exampleName), "example"));
        method.addBodyLine(String.format("return mapper.countByExample(example);"));
        sqlClass.addMethod(method);


        // class
        if (spring) {
            sqlClass.addImportedType("org.springframework.stereotype.Component");
            sqlClass.addImportedType("org.springframework.beans.factory.annotation.Autowired");
            sqlClass.addAnnotation("@Component");
        }
        sqlClass.addImportedType("java.util.List");

        GeneratedJavaFile file = new GeneratedJavaFile(sqlClass, daoTargetDir, javaFormatter);
        mapperJavaFiles.add(file);
    }

    private void createQueryFile(GeneratedJavaFile entityFile, GeneratedJavaFile javaFile, JavaFormatter javaFormatter, String baseName, List<GeneratedJavaFile> mapperJavaFiles, String queryName, String sqlName, String exampleName, boolean hasBlob) {
        FullyQualifiedJavaType createReturn;
        TopLevelClass queryClass = new TopLevelClass(daoTargetPackage + "." + queryName);
        queryClass.setVisibility(JavaVisibility.PUBLIC);
        queryClass.addImportedType("java.util.List");

        // constructor
        Method queryClassConMethod = new Method(queryName);
        queryClassConMethod.setName(queryName);
        queryClassConMethod.setConstructor(true);
        Parameter qc1 = new Parameter(new FullyQualifiedJavaType(sqlName), "sql");
        queryClassConMethod.addParameter(qc1);
        queryClassConMethod.addBodyLine("this.sql = sql;");
        queryClassConMethod.addBodyLine(String.format("this.example = new %s();", exampleName));
        queryClassConMethod.addBodyLine("this.criteria = this.example.createCriteria();");
        queryClassConMethod.addBodyLine(String.format("this.entity = new %s();", baseName));
        queryClass.addMethod(queryClassConMethod);

        // field
        Field f1 = new Field("sql", new FullyQualifiedJavaType(sqlName));
        f1.setVisibility(JavaVisibility.PRIVATE);
        queryClass.addField(f1);

        Field f2 = new Field("example", new FullyQualifiedJavaType(exampleName));
        f2.setVisibility(JavaVisibility.PRIVATE);
        queryClass.addField(f2);

        Field f3 = new Field("criteria", new FullyQualifiedJavaType(exampleName + "." + "Criteria"));
        f3.setVisibility(JavaVisibility.PRIVATE);
        queryClass.addField(f3);

        Field f4 = new Field("entity", new FullyQualifiedJavaType(baseName));
        f4.setVisibility(JavaVisibility.PRIVATE);
        queryClass.addField(f4);
        // Method
        Method m1 = new Method("list");
        m1.setVisibility(JavaVisibility.PUBLIC);
        createReturn = new FullyQualifiedJavaType("List");
        createReturn.addTypeArgument(new FullyQualifiedJavaType(baseName));
        m1.setReturnType(createReturn);
        m1.addBodyLine(String.format("return sql.list(example);"));
        queryClass.addMethod(m1);

        if (hasBlob) {
            Method m2 = new Method("listWithBlob");
            m2.setVisibility(JavaVisibility.PUBLIC);
            createReturn = new FullyQualifiedJavaType("List");
            createReturn.addTypeArgument(new FullyQualifiedJavaType(baseName));
            m2.setReturnType(createReturn);
            m2.addBodyLine(String.format("return sql.listWithBlob(example);"));
            queryClass.addMethod(m2);
        }

        Method m3 = new Method("one");
        m3.setVisibility(JavaVisibility.PUBLIC);
        createReturn = new FullyQualifiedJavaType(baseName);
        m3.setReturnType(createReturn);
        m3.addBodyLine(String.format("List<%s> list = list();", baseName));
        m3.addBodyLine(String.format("return list.isEmpty() ? null : list.get(0);"));
        queryClass.addMethod(m3);

        if (hasBlob) {
            Method m4 = new Method("oneBlob");
            m4.setVisibility(JavaVisibility.PUBLIC);
            createReturn = new FullyQualifiedJavaType(baseName);
            m4.setReturnType(createReturn);
            m4.addBodyLine(String.format("List<%s> list = listWithBlob();", baseName));
            m4.addBodyLine(String.format("return list.isEmpty() ? null : list.get(0);"));
            queryClass.addMethod(m4);
        }

        Method method = new Method("delete");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addBodyLine(String.format("if (!criteria.isValid()) {"));
        method.addBodyLine(String.format("return 0;"));
        method.addBodyLine(String.format("}"));
        method.addBodyLine(String.format("return sql.delete(example);"));
        queryClass.addMethod(method);

        method = new Method("update");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "value"));
        method.addBodyLine(String.format("if (!criteria.isValid()) {"));
        method.addBodyLine(String.format("return 0;"));
        method.addBodyLine(String.format("}"));
        method.addBodyLine(String.format("return sql.update(value, example);"));
        queryClass.addMethod(method);

        method = new Method("update");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addBodyLine(String.format("return sql.updateSelective(entity, example);"));
        queryClass.addMethod(method);

        if (hasBlob) {
            method = new Method("updateWithBLOBs");
            method.setVisibility(JavaVisibility.PUBLIC);
            method.setReturnType(new FullyQualifiedJavaType("int"));
            method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "value"));
            method.addBodyLine(String.format("if (!criteria.isValid()) {"));
            method.addBodyLine(String.format("return 0;"));
            method.addBodyLine(String.format("}"));
            method.addBodyLine(String.format("return sql.updateWithBLOBs(value, example);"));
            queryClass.addMethod(method);
        }

        method = new Method("updateSelective");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("int"));
        method.addParameter(new Parameter(new FullyQualifiedJavaType(baseName), "value"));
        method.addBodyLine(String.format("if (!criteria.isValid()) {"));
        method.addBodyLine(String.format("return 0;"));
        method.addBodyLine(String.format("}"));
        method.addBodyLine(String.format("return sql.updateSelective(value, example);"));
        queryClass.addMethod(method);


        method = new Method("count");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("long"));
        method.addBodyLine(String.format(" return sql.count(example);"));
        queryClass.addMethod(method);

        // from example
        TopLevelClass compilationUnit = (TopLevelClass) javaFile.getCompilationUnit();
        List<InnerClass> innerClasses = compilationUnit.getInnerClasses();
        InnerClass criteria = null;
        for (InnerClass innerClass : innerClasses) {
            if ("GeneratedCriteria".equals(innerClass.getType().getShortName())) {
                criteria = innerClass;
                break;
            }
        }

        if (criteria != null) {
            for (Method cmethod : criteria.getMethods()) {
                if (cmethod.getName().startsWith("and")) {

                    Method m = new Method(cmethod.getName());
                    List<String> ps = new ArrayList<>();
                    for (int i = 0; i < cmethod.getParameters().size(); i++) {
                        Parameter parameter = cmethod.getParameters().get(i);
                        m.addParameter(i, parameter);
                        ps.add(parameter.getName());
                    }
                    m.setReturnType(new FullyQualifiedJavaType(queryName));
                    m.addBodyLine(String.format("this.criteria = this.criteria.%s(%s);", cmethod.getName(), ps.stream().collect(Collectors.joining(","))));
                    m.addBodyLine(String.format("return this;"));
                    m.setVisibility(JavaVisibility.PUBLIC);
                    queryClass.addMethod(m);
                }
            }
        }

        TopLevelClass entityClass = (TopLevelClass) entityFile.getCompilationUnit();

        for (Method cmethod : entityClass.getMethods()) {
            if (cmethod.getName().startsWith("set")) {
                Method m = new Method(cmethod.getName());
                List<String> ps = new ArrayList<>();
                for (int i = 0; i < cmethod.getParameters().size(); i++) {
                    Parameter parameter = cmethod.getParameters().get(i);
                    m.addParameter(i, parameter);
                    ps.add(parameter.getName());
                }
                m.setReturnType(new FullyQualifiedJavaType(queryName));
                m.addBodyLine(String.format("this.entity.%s(%s);", cmethod.getName(), ps.stream().collect(Collectors.joining(","))));
                m.addBodyLine(String.format("return this;"));
                m.setVisibility(JavaVisibility.PUBLIC);
                queryClass.addMethod(m);
            }
        }


        GeneratedJavaFile queryFile = new GeneratedJavaFile(queryClass, daoTargetDir, javaFormatter);
        mapperJavaFiles.add(queryFile);
    }


    //    @Override
//    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable) {
//        List<GeneratedXmlFile> resultList = new ArrayList<>();
//        GeneratedXmlFile generatedXmlFile = new GeneratedXmlFile();
//        List<GeneratedXmlFile> generatedXmlFiles = introspectedTable.getGeneratedXmlFiles();
//        return super.contextGenerateAdditionalXmlFiles(introspectedTable);
//    }


    private FullyQualifiedJavaType example(String exampleType) {
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(exampleType);
        return type;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String classComment = null;

        try {
            Connection connection = getConnection(introspectedTable.getContext());
            // todo  只有在mysql 情况可以用
            if (false && connection instanceof JDBC4Connection) {

                Statement statement = connection.createStatement();
                String sql = String.format("SELECT TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = '%s' AND TABLE_SCHEMA = '%s'", introspectedTable.getFullyQualifiedTable().getIntrospectedTableName(), connection.getCatalog());

                System.out.println(sql);
                ResultSet resultSet = statement.executeQuery(sql);

                boolean next = resultSet.next();
                if (next) {
                    classComment = resultSet.getString("TABLE_COMMENT");
                }
                resultSet.close();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (classComment != null) {
            topLevelClass.addJavaDocLine("/**");
            Arrays.stream(classComment.split("\n|\r\n")).forEach(s -> {
                topLevelClass.addJavaDocLine(" * " + s);
            });
            topLevelClass.addJavaDocLine(" */");
        }

        if (moduleInterface != null) {
            FullyQualifiedJavaType superInterface = new FullyQualifiedJavaType(moduleInterface);
            topLevelClass.addImportedType(superInterface);
            topLevelClass.addSuperInterface(superInterface);
        }


        Method method = new Method("copy");
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("copy");
        FullyQualifiedJavaType model = topLevelClass.getType();
        method.setReturnType(model);

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        List<IntrospectedColumn> constructorColumns = introspectedTable
                .getAllColumns();

        StringBuilder sb = new StringBuilder();
        List<IntrospectedColumn> introspectedColumns = introspectedTable.getAllColumns();

        sb.append(model.getShortName());
        sb.append(" m = new ");
        sb.append(model.getShortName());
        sb.append("(); ");
        method.addBodyLine(sb.toString());


        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
            sb.setLength(0);
            sb.append("m."); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(" = "); //$NON-NLS-1$
            sb.append("this.");
            sb.append(introspectedColumn.getJavaProperty());
            sb.append(';');
            method.addBodyLine(sb.toString());
        }

        method.addBodyLine("return m;");

        topLevelClass.addMethod(method);
        return true;
    }

    private Connection getConnection(Context context) throws SQLException {
        ConnectionFactory connectionFactory;
        if (context.getJdbcConnectionConfiguration() != null) {
            connectionFactory = new JDBCConnectionFactory(context.getJdbcConnectionConfiguration());
        } else {
            connectionFactory = ObjectFactory.createConnectionFactory(context);
        }

        return connectionFactory.getConnection();
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        String remarks = introspectedColumn.getRemarks();
        if (remarks != null) {
            field.addJavaDocLine("/**");
            Arrays.stream(remarks.split("\n|\r\n")).forEach(s -> {
                field.addJavaDocLine(" * " + s);
            });
            field.addJavaDocLine(" */");
        }
        if ("Date".equals(field.getType().getShortName())) {
            field.setType(example("java.time.LocalDateTime"));
//            introspectedColumn.setJavaProperty("java.time.LocalDateTime");
        }
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        if ("Date".equals(method.getReturnType().get().getShortName())) {
            method.setReturnType(example("java.time.LocalDateTime"));
        }

        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        Parameter parameter = method.getParameters().get(0);
        if ("Date".equals(parameter.getType().getShortName())) {
            method.getParameters().remove(0);
            method.addParameter(0, new Parameter(example("java.time.LocalDateTime"), parameter.getName()));
        }
        method.addBodyLine("return this;");

        method.setReturnType(topLevelClass.getType());

        return true;
    }


    /////////// limit
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        PrimitiveTypeWrapper integerWrapper = FullyQualifiedJavaType.getIntInstance().getPrimitiveTypeWrapper();

        Field limit = new Field("limit", integerWrapper);
        limit.setName("limit");
        limit.setVisibility(JavaVisibility.PRIVATE);
        limit.setType(integerWrapper);
        topLevelClass.addField(limit);

        Method setLimit = new Method("setLimit");
        setLimit.setVisibility(JavaVisibility.PUBLIC);
        setLimit.setName("setLimit");
        setLimit.addParameter(new Parameter(integerWrapper, "limit"));
        setLimit.addBodyLine("this.limit = limit;");
        topLevelClass.addMethod(setLimit);

        Method getLimit = new Method("getLimit");
        getLimit.setVisibility(JavaVisibility.PUBLIC);
        getLimit.setReturnType(integerWrapper);
        getLimit.setName("getLimit");
        getLimit.addBodyLine("return limit;");
        topLevelClass.addMethod(getLimit);

        Field offset = new Field("offset", integerWrapper);
        offset.setName("offset");
        offset.setVisibility(JavaVisibility.PRIVATE);
        offset.setType(integerWrapper);
        topLevelClass.addField(offset);

        Method setOffset = new Method("setOffset");
        setOffset.setVisibility(JavaVisibility.PUBLIC);
        setOffset.setName("setOffset");
        setOffset.addParameter(new Parameter(integerWrapper, "offset"));
        setOffset.addBodyLine("this.offset = offset;");
        topLevelClass.addMethod(setOffset);

        Method getOffset = new Method("getOffset");
        getOffset.setVisibility(JavaVisibility.PUBLIC);
        getOffset.setReturnType(integerWrapper);
        getOffset.setName("getOffset");
        getOffset.addBodyLine("return offset;");
        topLevelClass.addMethod(getOffset);

        return true;
    }

    /**
     * 为Mapper.xml的selectByExample添加limit
     */
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        XmlElement ifLimitNotNullElement = new XmlElement("if");
        ifLimitNotNullElement.addAttribute(new Attribute("test", "limit != null"));

        XmlElement ifOffsetNotNullElement = new XmlElement("if");
        ifOffsetNotNullElement.addAttribute(new Attribute("test", "offset != null"));
        ifOffsetNotNullElement.addElement(new TextElement("limit ${offset}, ${limit}"));
        ifLimitNotNullElement.addElement(ifOffsetNotNullElement);

        XmlElement ifOffsetNullElement = new XmlElement("if");
        ifOffsetNullElement.addAttribute(new Attribute("test", "offset == null"));
        ifOffsetNullElement.addElement(new TextElement("limit ${limit}"));
        ifLimitNotNullElement.addElement(ifOffsetNullElement);

        element.addElement(ifLimitNotNullElement);

        return true;
    }

    @Override
    public boolean dynamicSqlSupportGenerated(TopLevelClass supportClass, IntrospectedTable introspectedTable) {

        introspectedTable.setMyBatisDynamicSqlSupportType("DSS");

        return true;
    }
}


