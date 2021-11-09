package game.manager;

import game.base.AbsLifecycle;
import game.module.http.UserController;
import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.ReDocOptions;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author Yunzhe.Jin
 * 2021/11/8 21:15
 */
public class HttpManager extends AbsLifecycle {


    @Override
    public void start() {
        super.start();
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(getConfiguredOpenApiPlugin());
            config.defaultContentType = "application/json";
        });

        app.routes(() -> {
            ApiBuilder.post("/user/register", UserController::register);
            ApiBuilder.post("/user/login", UserController::login);
        });
        app.start(7000);
        System.out.println("Check out ReDoc docs at http://localhost:7000/redoc");
        System.out.println("Check out Swagger UI docs at http://localhost:7000/swagger-ui");
    }

    private static OpenApiPlugin getConfiguredOpenApiPlugin() {
        Info info = new Info().version("1.0").description("User API");
        OpenApiOptions options = new OpenApiOptions(info)
                .activateAnnotationScanningFor("game")
                .path("/swagger-docs") // endpoint for OpenAPI json
                .swagger(new SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
                .reDoc(new ReDocOptions("/redoc")) // endpoint for redoc
                .defaultDocumentation(doc -> {
                });
        return new OpenApiPlugin(options);
    }

    public static void main(String[] args) {
        new HttpManager().start();

    }
}
