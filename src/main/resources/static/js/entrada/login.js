var current = null;
document.querySelector('#email').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: 0,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#password').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -336,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
document.querySelector('#submit').addEventListener('focus', function(e) {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -730,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '530 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});

// validation for login page
function Verify()
{
    var userx =  document.getElementById("email").value;
    var passx = document.getElementById("password").value;
    var x = userx.toString();
    var y = passx.toString();

// data from AIP '---->>>jsonplaceholder.typicode<<<----'
    let count=0;
    let emailS = [];
    let passwordS = [];
    fetch("https://jsonplaceholder.typicode.com/users")
        .then(res => {
            return res.json();
        })
        .then((data) => {
            data.forEach((user) => {

                let email = user.email;
                let password = user.phone;
                emailS[count] = email;
                passwordS[count] = password;
                count+=1;
            })
//lists to dictionary `{users}`
            const users = emailS.reduce((acc, curr, i) => {
                acc[curr] = passwordS[i];
                return acc;
            }, {});
            checkCredentials(x,y,users);
        });

    function checkCredentials(email, password,users)
    {
        if (users[email] === password)
        {

            alert("Vaildation success");

        }
        else
        {

            alert("Invalid username or password");

        }
    }
};