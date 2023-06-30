import com.egsys.crud.CrudApplication
import com.egsys.crud.controller.TaskController
import com.egsys.crud.model.MockitoHelper
import com.egsys.crud.model.TaskFormTest
import com.egsys.crud.model.TaskViewTest
import com.egsys.crud.model.UpdateTaskForm
import com.egsys.crud.service.TaskService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest(TaskController::class)
@ExtendWith(MockitoExtension::class)
@ContextConfiguration(classes = [CrudApplication::class])
class TaskControllerTest {

    @MockBean
    private lateinit var taskService: TaskService


    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `should return list of tasks`() {
        val tasks = PageImpl(listOf(TaskViewTest.build()))
        Mockito.`when`(taskService.list(MockitoHelper.anyObject() ,MockitoHelper.anyObject())).thenReturn(tasks);
        val tasksAsJson = objectMapper.writeValueAsString(tasks)
        mockMvc.perform(get("/tasks")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().string(tasksAsJson))

    }
    @Test
    fun `should return list with expected id`() {
        val task = TaskViewTest.build()
        Mockito.`when`(taskService.searchForId(1)).thenReturn(task);
        val tasksAsJson = objectMapper.writeValueAsString(task)
        mockMvc.perform(get("/tasks/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().string(tasksAsJson))

    }

    @Test
    fun `should register in database`() {
        val task = TaskViewTest.build()
        val taskForm =  TaskFormTest.build()
        val taskFormAsJson = objectMapper.writeValueAsString(taskForm)
        Mockito.`when`(taskService.register(MockitoHelper.anyObject())).thenReturn(task);
        val tasksAsJson = objectMapper.writeValueAsString(task)
        mockMvc.perform(post("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(taskFormAsJson))
            .andExpect(status().isCreated)
            .andExpect(content().string(tasksAsJson))

    }

    @Test
    fun `should edit in request`() {
        val task = TaskViewTest.build()
        val taskForm =  UpdateTaskForm.build()
        val taskFormAsJson = objectMapper.writeValueAsString(taskForm)
        Mockito.`when`(taskService.update(MockitoHelper.anyObject())).thenReturn(task);
        val tasksAsJson = objectMapper.writeValueAsString(task)
        mockMvc.perform(put("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(taskFormAsJson))
            .andExpect(status().isOk)
            .andExpect(content().string(tasksAsJson))

    }
    @Test
    fun `should delete in request`() {
        Mockito.doNothing().`when`(taskService).delete(1)
        mockMvc.perform(delete("/tasks/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)

    }



}
