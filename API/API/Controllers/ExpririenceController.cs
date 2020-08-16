using API.Domain.Entities;
using LiteDB;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;

namespace API.Controllers
{
    [Route("api/expririence/")]
    public class ExpririenceController : Controller
    {

        [HttpPost]
        [Route("AddTask")]
        public IActionResult AddTask([FromBody] AddTaskRequest request)
        {
            var task = new Domain.Entities.Tarefa(request.Nome);
            using (var db = new LiteDatabase("banco.db"))
            {
                var taskCollection = db.GetCollection<Tarefa>("tarefa");
                taskCollection.Insert(task);
               
            }
            return Ok(new { Tarefa = task, Mensagem = "Operação realizada com sucesso!" });
        }

        [HttpPut]
        [Route("UpdateTask")]
        public IActionResult UpdateTask([FromBody] UpDateTaskRequest request)
        {
            using (var db = new LiteDatabase("banco.db"))
            {
                var taskCollection = db.GetCollection<Tarefa>("tarefa");
                var task = taskCollection.FindOne(x => x.Id == request.Id);

                task.Nome = request.Nome;
                task.Done = request.Done;

                taskCollection.Update(task);

            }
            return Ok(new { Mensagem = "Operação realizada com sucesso!" });
        }

        [HttpGet()]
        [Route("ListTask")]
        public IActionResult ListTask()
        {
            List<Tarefa> tarefas;

            using (var db = new LiteDatabase("banco.db"))
            {
                var taskCollection = db.GetCollection<Tarefa>("tarefa");
                tarefas = taskCollection.FindAll().ToList();

            }
            return Ok(tarefas);
        }

        [HttpDelete("{id:guid}")]
        [Route("DelTask")]
        public IActionResult DelTask(Guid id)
        {
            using (var db = new LiteDatabase("banco.db"))
            {
                var taskCollection = db.GetCollection<Tarefa>("tarefa");
                taskCollection.Delete(id);
                
                return Ok(new { Mensagem = "Exclusão realizada com sucesso!" });
            }
        }

    }
}
