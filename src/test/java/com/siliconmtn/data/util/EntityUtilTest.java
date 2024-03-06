/* (C)2024 */
package com.siliconmtn.data.util;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import com.siliconmtn.data.lang.ClassUtil;
import com.siliconmtn.io.api.base.BaseDTO;
import com.siliconmtn.io.api.base.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

/****************************************************************************
 * <b>Title</b>: EntityUtilTest.java
 * <b>Project</b>: spaceforce-survey
 * <b>Description: </b> Used to test the EntityUtil class for converting DTOs in to Entities
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author Chris Scarola
 * @version 3.0
 * @since Feb 4, 2021
 * @updates:
 ****************************************************************************/
class EntityUtilTest {

    private static CategoryDTO dto;
    private static CategoryDTO nestedDTO;
    private static Category category;
    private static CategoryWithoutId categoryWithoutId;
    private static Category nestedCategory;
    private static CategoryWithoutId nestedCategoryWithoutId;

    @MockBean private static EntityManager entityManager;
    private static EntityUtil entityUtil;

    /**
     * Steps to execute before each and every test
     * Defining category dto and entity object with data
     */
    @BeforeAll
    static void setup() {
        dto = new CategoryDTO();
        dto.setCode("CODE");
        dto.setGroupCode("CODE");
        dto.setParentCode(null);
        dto.setDepth((short) 0);
        dto.setName("Name");

        category = new Category();
        category.setCode("CODE");
        category.setGroupCode("CODE");
        category.setParentCode(null);
        category.setDepth((short) 0);
        category.setName("Name");
        category.setTest(TestEnum.ONE);

        categoryWithoutId = new CategoryWithoutId();
        categoryWithoutId.setCode("CODE");
        categoryWithoutId.setGroupCode("CODE");
        categoryWithoutId.setParentCode(null);
        categoryWithoutId.setDepth((short) 0);
        categoryWithoutId.setName("Name");
        categoryWithoutId.setTest(TestEnum.ONE);

        nestedDTO = new CategoryDTO();
        nestedDTO.setCode("CODE2");
        nestedDTO.setGroupCode("CODE");
        nestedDTO.setParentCode("CODE");
        nestedDTO.setDepth((short) 1);
        nestedDTO.setName("Name2");
        nestedDTO.setTest(TestEnum.ONE);

        nestedCategory = new Category();
        nestedCategory.setCode("CODE2");
        nestedCategory.setGroupCode("CODE");
        nestedCategory.setParentCode(category);
        nestedCategory.setDepth((short) 1);
        nestedCategory.setName("Name2");
        nestedCategory.setTest(TestEnum.ONE);

        nestedCategoryWithoutId = new CategoryWithoutId();
        nestedCategoryWithoutId.setCode("CODE2");
        nestedCategoryWithoutId.setGroupCode("CODE");
        nestedCategoryWithoutId.setParentCode(categoryWithoutId);
        nestedCategoryWithoutId.setDepth((short) 1);
        nestedCategoryWithoutId.setName("Name2");
        nestedCategoryWithoutId.setTest(TestEnum.ONE);

        entityManager = Mockito.mock(EntityManager.class);
        entityUtil = new EntityUtil(entityManager);
    }

    /**
     * Test method for {@link com.smt.ezform.core.EntityUtil#dtoToEntity(Object, Class<T>, EntityManager)}
     * @param <T>
     */
    @Test
    void testDtoToEntityClassNull() throws Exception {
        Class<Category> clazz = null;
        assertEquals(null, entityUtil.dtoToEntity(null, Category.class));
        assertEquals((Object) null, entityUtil.dtoToEntity(dto, clazz));
    }

    /**
     * Test method for {@link com.smt.ezform.core.EntityUtil#dtoToEntity(Object, Class<T>, EntityManager)}
     * @param <T>
     */
    @Test
    void testDtoToEntityObjectNull() throws Exception {
        assertEquals(null, entityUtil.dtoToEntity(null, category));
        assertEquals((Object) null, entityUtil.dtoToEntity(dto, (BaseEntity) null));
    }

    /**
     * Test method for {@link com.smt.ezform.core.EntityUtil#dtoToEntity(Object, Class<T>, EntityManager)}
     */
    @Test
    void testDtoToEntity() throws Exception {
        doReturn(category)
                .when(entityManager)
                .getReference(ArgumentMatchers.any(), ArgumentMatchers.any());
        Category result = entityUtil.dtoToEntity(dto, Category.class);
        assertEquals(category.getCode(), result.getCode());
        assertEquals(category.getGroupCode(), result.getGroupCode());
        assertEquals(category.getParentCode(), result.getParentCode());
        assertEquals(category.getDepth(), result.getDepth());
        assertEquals(category.getName(), result.getName());
    }

    /**
     * Test method for {@link com.smt.ezform.core.EntityUtil#dtoToEntity(Object, Class<T>, EntityManager)}
     */
    @Test
    void testDtoToEntityWithNestedType() throws Exception {
        doReturn(category)
                .when(entityManager)
                .getReference(ArgumentMatchers.any(), ArgumentMatchers.any());
        Category result = entityUtil.dtoToEntity(nestedDTO, Category.class);
        assertEquals(nestedCategory.getCode(), result.getCode());
        assertEquals(nestedCategory.getGroupCode(), result.getGroupCode());
        assertEquals(nestedCategory.getParentCode().getCode(), result.getParentCode().getCode());
        assertEquals(nestedCategory.getDepth(), result.getDepth());
        assertEquals(nestedCategory.getName(), result.getName());
    }

    /**
     * Test method for {@link com.smt.ezform.core.EntityUtil#dtoToEntity(Object, Class<T>, EntityManager)}
     */
    @Test
    void testDtoToEntityThrow() throws Exception {
        doThrow(new IllegalArgumentException())
                .when(entityManager)
                .getReference(ArgumentMatchers.any(), ArgumentMatchers.any());
        Category result = entityUtil.dtoToEntity(nestedDTO, Category.class);
        assertEquals(null, result);
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#dtoListToEntity(java.util.List, java.lang.Class)}.
     */
    @Test
    void testDtoListToEntity() throws Exception {
        List<BaseDTO> dtos = new ArrayList<>();
        dtos.add(dto);
        dtos.add(nestedDTO);

        List<Category> categories = entityUtil.dtoListToEntity(dtos, Category.class);
        assertEquals(2, categories.size());
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityToDto(java.lang.Object, java.lang.Class)}.
     */
    @Test
    void testEntityToDtoNull() throws Exception {
        assertEquals(null, entityUtil.entityToDto(null, CategoryDTO.class));
        assertEquals((Object) null, entityUtil.entityToDto(category, null));
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityToDto(java.lang.Object, java.lang.Class)}.
     */
    @Test
    void testEntityToDto() throws Exception {
        CategoryDTO result = entityUtil.entityToDto(category, CategoryDTO.class);
        assertEquals(category.getCode(), result.getCode());
        assertEquals(category.getGroupCode(), result.getGroupCode());
        assertEquals(category.getParentCode(), result.getParentCode());
        assertEquals(category.getDepth(), result.getDepth());
        assertEquals(category.getName(), result.getName());
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityToDto(java.lang.Object, java.lang.Class)}.
     */
    @Test
    void testEntityToDtoMissingAnnotation() throws Exception {
        CategoryDTO result = entityUtil.entityToDto(nestedCategoryWithoutId, CategoryDTO.class);
        assertEquals(nestedCategoryWithoutId.getCode(), result.getCode());
        assertEquals(nestedCategoryWithoutId.getGroupCode(), result.getGroupCode());
        assertEquals(null, result.getParentCode());
        assertEquals(nestedCategoryWithoutId.getDepth(), result.getDepth());
        assertEquals(nestedCategoryWithoutId.getName(), result.getName());
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityToDto(java.lang.Object, java.lang.Class)}.
     */
    @Test
    void testEntityToDtoWithNestedType() throws Exception {
        CategoryDTO result = entityUtil.entityToDto(nestedCategory, CategoryDTO.class);
        assertEquals(nestedCategory.getCode(), result.getCode());
        assertEquals(nestedCategory.getGroupCode(), result.getGroupCode());
        assertEquals(nestedCategory.getParentCode().getCode(), result.getParentCode());
        assertEquals(nestedCategory.getDepth(), result.getDepth());
        assertEquals(nestedCategory.getName(), result.getName());
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityToDto(java.lang.Object, java.lang.Class)}.
     */
    @Test
    void testEntityToDtoThrow() throws Exception {
        try (MockedStatic<ClassUtil> classUtilMock = Mockito.mockStatic(ClassUtil.class)) {
            classUtilMock
                    .when(
                            () ->
                                    ClassUtil.getFieldsByAnnotation(
                                            ArgumentMatchers.any(), ArgumentMatchers.any()))
                    .thenThrow(new RuntimeException());
            CategoryDTO result = entityUtil.entityToDto(nestedCategory, CategoryDTO.class);
            assertEquals(null, result);
        }
    }

    /**
     * Test method for {@link com.siliconmtn.data.util.EntityUtil#entityListToDto(java.util.List, java.lang.Class)}.
     */
    @Test
    void testEntityListToDto() throws Exception {
        List<BaseEntity> entities = new ArrayList<>();
        entities.add(category);
        entities.add(nestedCategory);

        List<CategoryDTO> categories = entityUtil.entityListToDto(entities, CategoryDTO.class);
        assertEquals(2, categories.size());
    }
}

enum TestEnum {
    ONE,
    TWO,
    THREE
}

@Data
@NoArgsConstructor
class CategoryDTO implements BaseDTO {
    private static final long serialVersionUID = 210128864839657123L;
    private String code;
    private String groupCode;
    private String parentCode;
    private short depth;
    private String name;
    private TestEnum test;
}

@Data
@NoArgsConstructor
class Category implements BaseEntity {
    private static final long serialVersionUID = 4457516413601618139L;
    @Id private String code;
    private String groupCode;
    private Category parentCode;
    private short depth;
    private String name;
    private TestEnum test;
    private ZonedDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC);
}

@Data
@NoArgsConstructor
class CategoryWithoutId implements BaseEntity {
    private static final long serialVersionUID = 6215676666713039022L;
    private String code;
    private String groupCode;
    private CategoryWithoutId parentCode;
    private short depth;
    private String name;
    private TestEnum test;
    private ZonedDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC);
}
