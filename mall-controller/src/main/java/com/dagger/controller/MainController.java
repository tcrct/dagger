package com.dagger.controller;


import com.dagger.service.MainService;
import com.dagger.entity.User;
import com.duangframework.kit.ToolsKit;
import com.duangframework.mvc.annotation.Controller;
import com.duangframework.mvc.annotation.Import;
import com.duangframework.mvc.annotation.Mapping;
import com.duangframework.mvc.core.BaseController;
import com.duangframework.vtor.annotation.DuangId;

/**
 * Hello world!
 *
 */
@Controller
@Mapping(value = "/main")
public class MainController extends BaseController
{
    @Import
    private MainService mainService;

    @Mapping(value = "index")
    public void index(String key, String name, int sex)  {
        String str = mainService.main("laotang");
        try {
            double value = 1/0;
            returnText(str);
        } catch (Exception e) {
            returnText(e.getMessage());
        }
    }

    @Mapping(value = "/setvalue")
    public void setvalue(String key, String name, int sex, long age, Double money)
    {
        System.out.println("##################key: " + key+"                  "+name+"             "+sex+"                  "+age+"         "+money);
        String str = mainService.main(key);
        try {
            returnText(str);
        } catch (Exception e) {
            returnText(e.getMessage());
        }
    }

    @Mapping(value = "/save")
    public void save(@DuangId String id, User user)
    {
        System.out.println("##################user: "+ ToolsKit.toJsonString(user));
        String str = mainService.main(user.getName());
        try {
            returnText(str);
        } catch (Exception e) {
            returnText(e.getMessage());
        }
    }
}
