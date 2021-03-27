# Post-Secondary-App

Project 2 of 3 of ICS4U summatives.

Many internal issues occured within the group, which led to an embarassing, mismatched, "final product" (if you could even call it that).

Anyway, here are screenshots of the part of the project I worked on. (Not my best work, see [Legato Learning](https://github.com/JacobPamintuan/Legato-Learning) or [Amazing Labyrinth](https://github.com/JacobPamintuan/AmazingLabyrinth))

---
#### Basic Login and Signup
<img width="812" alt="Login" src="https://user-images.githubusercontent.com/36178603/112705977-821b1f00-8e77-11eb-9eea-b58c847f5179.png">
<img width="812" alt="Sign up" src="https://user-images.githubusercontent.com/36178603/112705979-83e4e280-8e77-11eb-8ba0-799db8d78b9e.png">

#### University Matcher
<img width="1402" alt="Uni Matcher" src="https://user-images.githubusercontent.com/36178603/112706076-446ac600-8e78-11eb-9710-5d89cf902567.png">
- This quiz matches you to your ideal university based on the answers to the questions
- If the user selects "yes" to any of the following questions, a slider appears and the user can input how important of a factor it is
- Clicking "Get Result" opens a popup with the school best suited for the user based on their input
  - In this case it's Waterloo:
<img width="527" alt="Screen Shot 2021-03-26 at 9 11 25 PM" src="https://user-images.githubusercontent.com/36178603/112706086-4fbdf180-8e78-11eb-83c6-ff4da8fa1498.png">
- Within the popup, there is a hyper-link that takes the user to the corresponding universitiy's website

---

### Things I Learned
- When electing a project manager, don't base it purely of their grades
  - Just because someone can code, doesn't mean they can code with and lead a group
- Set proper deadlines
- Standardize a common theme before working on GUI
- Set often group meetings (make sure everyone attends, especially the project manager)
- Focus on finishing what is important, rather than focusing on gimmicks
  - Time management is key and different when working with others
- Stepping up to the plate when the project manager does not fulfill their role

### Skills I developed
- Using a comparator
- Weights and biases
- Learned how to read csv files
- Communication and collaboration skills - working in groups

---

A list of classes I was responsible for:
- [LoginGUI.java](src/postApp/LoginGUI.java)
- [SignUp.java](src/postApp/SignUp.java)
  - (SignUp2.java is someone recreating the whole class themselves, for no reason except pride)

Extra feature I added (the Uni Quiz):
- [niversityQuiz.java](src/postApp/UniversityQuiz.java) (the GUI)
- [UniversityWeights.java](src/postApp/UniversityWeights.java) (the logic)
