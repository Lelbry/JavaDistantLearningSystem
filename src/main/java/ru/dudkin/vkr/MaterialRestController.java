package ru.dudkin.vkr;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ru.dudkin.vkr.model.Material;
import ru.dudkin.vkr.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialRestController {
    private final MaterialService materialService;

    @Autowired
    public MaterialRestController(MaterialService materialService){this.materialService = materialService;}

    @PostMapping("/")
    @Operation(summary = "этот метод добавляет Текст (material) ")
    public void add(@Parameter(description = "Введите номер или название с каким Разделом будет связан Текст")
                    @RequestParam String number_Subtitle_Text_Refer,
                    @Parameter(description = "Основной Текст для данной связки")
                    @RequestParam String main_Txt) {materialService.add(number_Subtitle_Text_Refer, main_Txt);}

    @DeleteMapping("/")
    @Operation(summary = "этот метод удаляет строчку из таблицы Material из базы даннах по id")
    public void delete(@Parameter(description = "укажите Id из таблицы Material которую нужно удалить из Базы данных")
                       @RequestParam long id){materialService.remove(id);}

    @PutMapping("/")
    @Operation(summary = "этот метод позволит редактировать строку из раздела Material, находящеюся в Базе данны")
    public void edit(@Parameter(description = "укажите Id строки, по которому нужно внести изменения") @RequestParam long id,
                     @Parameter(description = "Введите новый номер или название с каким Разделом (subTheme) будет связан Текст")
                     @RequestParam String new_number_Subtitle_Text_Refer, @Parameter(description = "Введите новый текст")
                     @RequestParam String new_main_Txt){materialService.edit(id, new_number_Subtitle_Text_Refer, new_main_Txt);}

    @GetMapping("/")
    @Operation(summary = "этот метод выводит список всех строк содержащихся в таблице Material которые хранятся в базе данных")
    public List<Material> get(){return materialService.getList();}
}
