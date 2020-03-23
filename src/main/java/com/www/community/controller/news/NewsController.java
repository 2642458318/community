package com.www.community.controller.news;

import com.github.pagehelper.PageInfo;
import com.www.community.model.GenericListResponse;
import com.www.community.model.GenericResponse;
import com.www.community.model.entity.news.NewsCategoryEntity;
import com.www.community.model.param.news.AddNewsCategoryParam;
import com.www.community.model.param.news.AlterNewsCategoryParam;
import com.www.community.service.local.news.NewsCategoryService;
import com.www.community.service.local.news.impl.NewsCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "咨询管理", tags = {"News-Api"}, description = "新闻咨询管理接口")
@RestController
@RequestMapping(value = "news")
public class NewsController {
    @Autowired
    private NewsCategoryService newsCategoryService;

    @ApiOperation(value = "咨询分类创建接口", notes = "咨询分类创建", httpMethod = "POST")
    @PostMapping(value = "/addCategory", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> addCategory(@RequestBody AddNewsCategoryParam addNewsCategoryParam,
                                                       @RequestHeader(value = "userId", required = true)
                                                       @ApiParam(value = "userId") String userCode) {
        addNewsCategoryParam.setUserCode(userCode);
        newsCategoryService.addCategory(addNewsCategoryParam);
        return GenericResponse.ok();
    }

    @ApiOperation(value = "咨询分类查询", notes = "咨询分类查询", httpMethod = "GET")
    @GetMapping(value = "/gradingCategoryList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericListResponse<NewsCategoryEntity>> categoryList(@RequestParam(value = "parentId", required = false) Integer parentId,
                                                                                @RequestParam(value = "categoryName", required = false) String categoryName,
                                                                                @RequestParam(value = "pn") Integer pn,
                                                                                @RequestParam(value = "ps") Integer ps) {
        PageInfo<NewsCategoryEntity> newsCategoryEntityPageInfo = newsCategoryService.categoryList(parentId, categoryName, pn, ps);
        return GenericListResponse.listAndCount(newsCategoryEntityPageInfo.getList(), newsCategoryEntityPageInfo.getTotal());
    }

    @ApiOperation(value = "咨询分类删除接口", notes = "咨询分类删除接口", httpMethod = "DELETE")
    @DeleteMapping(value = "/deleteCategory", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> deleteCategory(Integer[] categoryIds) {
        if (categoryIds == null || categoryIds.length == 0) {
            return GenericResponse.ng("请先传入ID");
        }
        newsCategoryService.deleteCategory(categoryIds);
        return GenericResponse.ok();
    }

    @ApiOperation(value = "资讯分类修改接口", notes = "资讯分类修改接口", httpMethod = "PUT")
    @PutMapping(value = "/updateCategory", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericResponse> updateCategory(@RequestBody AlterNewsCategoryParam alterNewsCategoryParam,
                                                          @RequestHeader(value = "userId", required = false)
                                                          @ApiParam(value = "userCode") String userCode) {
        alterNewsCategoryParam.setUserCode(userCode);
        newsCategoryService.updateNewsItemCategory(alterNewsCategoryParam);
        return GenericResponse.ok();
    }

    @ApiOperation(value = "资讯分类查询（层级）", notes = "资讯分类查询（层级）", httpMethod = "GET")
    @GetMapping(value = "findAllRecursion", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericListResponse<NewsCategoryEntity>> findAllRecursion() {
        List<NewsCategoryEntity> allRecursion = newsCategoryService.findAllRecursion();
        return GenericListResponse.listNoCount(allRecursion);
    }

    @ApiOperation(value = "资讯分类查询（无分页）",notes = "资讯分类查询（无分页）",httpMethod = "GET")
    @GetMapping(value = "/categoryListNoPage",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<GenericListResponse<NewsCategoryEntity>> categoryListNoPage() {
        List<NewsCategoryEntity> list = newsCategoryService.categoryListNoPage();
        return GenericListResponse.listNoCount(list);
    }
}
