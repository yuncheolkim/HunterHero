package game.module.http;

import com.cloverfew.repository.UserRepository;
import com.cloverfew.repository.mybatis.User;
import game.base.Logs;
import game.manager.RepositoryManager;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;

import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/11/8 21:36
 */
public class UserController {

    @OpenApi(
            summary = "Create user",
            operationId = "createUser",
            path = "/user/register",
            method = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = RegisterRequest.class)),
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = CommonResponse.class))
            })
    public static void register(Context ctx) {
        RegisterRequest registerRequest = ctx.bodyAsClass(RegisterRequest.class);
        System.out.println(registerRequest.toString());
        UserRepository repo = RepositoryManager.getRepo(UserRepository.class);

        Optional<User> byAccount = repo.findByAccount(registerRequest.getAccount());
        CommonResponse obj = new CommonResponse();

        if (byAccount.isPresent()) {
            obj.code = 2;
        } else {

            var user = new User();
            user.setAccount(registerRequest.account);
            user.setPassword(registerRequest.password);
            try {
                repo.insert(user);
            } catch (Exception e) {
                Logs.C.error(e);
                obj.code = 2;
            }
        }
        ctx.json(obj);
    }

    @OpenApi(
            summary = "登录",
            operationId = "登錄",
            path = "/user/login",
            method = HttpMethod.POST,
            requestBody = @OpenApiRequestBody(content = @OpenApiContent(from = LoginRequest.class)),
            responses = {
                    @OpenApiResponse(status = "200", content = @OpenApiContent(from = LoginResponse.class))
            })
    public static void login(Context ctx) {
        LoginRequest req = ctx.bodyAsClass(LoginRequest.class);
        System.out.println(req.toString());
        UserRepository repo = RepositoryManager.getRepo(UserRepository.class);

        Optional<User> user = repo.login(req.getAccount(), req.password);
        LoginResponse obj = new LoginResponse();

        if (user.isEmpty()) {
            obj.code = 2;
        } else {
            var u = user.get();
            obj.id = u.getId();
            obj.account = u.getAccount();
            obj.token = "token";
        }
        ctx.json(obj);
    }

}
