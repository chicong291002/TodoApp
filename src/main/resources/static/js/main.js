var socket = new SockJS("/todos");
var stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
    stompClient.subscribe("/topic/todos", function(response) {
        console.log("data");
    })
});

document.querySelector('#add-todo-form').addEventListener('submit', function(event) {
    event.preventDefault();
    var todoTitleInput = document.querySelector('#todo-title');
    var todoContentInput = document.querySelector('#todo-content');
    var todoStatusInput = document.querySelector('#todo-status');
    var todoUserIdInput = document.querySelector('#todo-user');

    var todo = {
        title: todoTitleInput.value,
        content: todoContentInput.value,
        status: todoStatusInput.value,
        user: {
            userId: parseInt(todoUserIdInput.value)
        }
    };

    stompClient.send("/app/todo.add", {}, JSON.stringify(todo));
    todoTitleInput.value = '';
    todoContentInput.value = '';
    todoStatusInput.value = '';
    todoUserIdInput.value = '';
    setTimeout(function() {
        window.location.href = '/todos';
    }, 100);
});

// Handle update todo
document.querySelector('#update-todo-form').addEventListener('submit', function(event) {
    event.preventDefault();
    var todoTitleInput = document.querySelector('#todo-title');
    var todoDescriptionInput = document.querySelector('#todo-description');
    var todoStatusInput = document.querySelector('#todo-status');
    var todoUserIdInput = document.querySelector('#todo-user');
    var todo = {
        title: todoTitleInput.value,
        description: todoDescriptionInput.value,
        status: todoStatusInput.value,
        user: {
            userId: parseInt(todoUserIdInput.value)
        }
    };
    stompClient.send("/app/todo.update", {}, JSON.stringify(todo));
    todoTitleInput.value = '';
    todoDescriptionInput.value = '';
    todoStatusInput.value = '';
    todoUserIdInput.value = '';
     setTimeout(function() {
            window.location.href = '/todos';
        }, 100);
});

// Handle delete todo
document.querySelector('#delete-todo-form').addEventListener('submit', function(event) {
    event.preventDefault();
    var todoIdInput = document.querySelector('#todoId');
    stompClient.send("/app/todo.remove", {}, JSON.stringify({
        todoId: todoIdInput.value
    }));
    todoIdInput.value = '';
     setTimeout(function() {
            window.location.href = '/todos';
        }, 100);
});