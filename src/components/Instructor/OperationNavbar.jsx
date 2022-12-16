import {createSearchParams, Link, useNavigate,Navigate, useMatch, useResolvedPath, useSearchParams} from "react-router-dom"
import React, {useState} from "react";

export default function OperationNavbar() {
    const [searchParam] = useSearchParams();
    const [mouseOver, setMouseOver] = useState(false);
    function handleMouse(){
        setMouseOver(true);
    }
    function handleMouseOut(){
        setMouseOver(false);
    }

    function CustomLink({ to, children, ...props }) {
        const navigate = useNavigate();
        const resolvedPath = useResolvedPath(to)
        const isActive = useMatch({ path: resolvedPath.pathname, end: true })

        function onClick(props)
        {

            navigate(
                {
                    pathname: resolvedPath.pathname,
                    search: createSearchParams(
                        {
                            id: searchParam.get("id"),
                        }).toString()
                });
        }

        return (
            <li className={isActive ? "active" : ""}>
                <button
                    className={isActive ? "activeButton" : "normalNavbarButton"}
                    onClick={onClick}>
                    {children}
                </button>
            </li>
        )
    }
    return (
        <nav className="opNav">
            <ul>

                <CustomLink to="/InstructorMainPage">Home</CustomLink>
                <CustomLink to="/InstructorUploadTaskPage">Upload Task</CustomLink>
                <CustomLink to="/InstructorTaskListPage">TaskList</CustomLink>
            </ul>
        </nav>

    )
}